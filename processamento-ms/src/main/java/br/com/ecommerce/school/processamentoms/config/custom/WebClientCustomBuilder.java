package br.com.ecommerce.school.processamentoms.config.custom;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class WebClientCustomBuilder<T> {

    private final WebClientCustomBuilder<T> builder;
    private String baseUrl;
    private String uri;
    private IErroNotificacaoDTO notificacaoDTO;
    private Object body;
    private final Map<String, Object> uriVariables = new HashMap<>();
    private HttpMethod httpMethod;
    private INotificarErro notificarErro;
    private final List<ExchangeFilterFunction> filters = new ArrayList<>();
    private Class<T> tClass;

    public WebClientCustomBuilder() {
        builder = this;
    }

    /**
     * @Documentation
     * @Class MethodStepBuilder
     *
     * @Nota:
     *      Implenta passos para adicionar
     *      -   Metodos HTTP
     *      -   Filters
     *      -   Devolve WebClient
     */
    class MethodStepBuilder implements IMethodStepBuilder<T> {

        @Override
        public IBodyStepBuilder<T> withPut() {
            builder.httpMethod = HttpMethod.PUT;
            return new BodyStepBuilder();
        }

        @Override
        public IBuildStepBuilder<T> withGet() {
            builder.httpMethod = HttpMethod.GET;
            return new BuildStepBuilder();
        }

        @Override
        public IBodyStepBuilder<T> withPost() {
            builder.httpMethod = HttpMethod.POST;
            return new BodyStepBuilder();
        }

        @Override
        public IMethodStepBuilder<T> filter(ExchangeFilterFunction filter) {
            builder.filters.add(filter);
            return this;
        }

        @Override
        public IMethodStepBuilder<T> filters(List<ExchangeFilterFunction> filters) {
            builder.filters.addAll(filters);
            return this;
        }

        @Override
        public WebClient getWebClient() {
            return builder.getBuilder();
        }
    }


    /**
     * @Documentation
     * @Class BodyStepBuilder
     *
     * @Nota:
     *      Implenta passos para adicionar:
     *      -   Body request
     *      -   Path parameters
     *      -   Notificar Error
     *      -   Build
     */
    class BodyStepBuilder implements IBodyStepBuilder<T> {

        private final IBuildStepBuilder<T> buildStepBuilder;

        BodyStepBuilder() {
            this.buildStepBuilder = new BuildStepBuilder();
        }

        @Override
        public IBuildStepBuilder<T> withBody(Object body) {
            builder.body = body;
            return this.buildStepBuilder;
        }

        @Override
        public IBodyStepBuilder<T> withPathParam(String key, Object value){
            this.buildStepBuilder.withPathParam(key, value);
            return this;
        }

        @Override
        public IBodyStepBuilder<T> withPathParams(Map<String, ?> uriVariables) {
            this.buildStepBuilder.withPathParams(uriVariables);
            return this;
        }

        @Override
        public ResponseEntity<T> build() {
            return this.buildStepBuilder.build();
        }

        @Override
        public IBuildStepBuilder<T> withNotificarError(INotificarErro notificarErro, IErroNotificacaoDTO notificacaoDTO) {
            return this.buildStepBuilder.withNotificarError(notificarErro, notificacaoDTO);
        }
    }

    /**
     * @Documentation
     * @Nota:
     *      Implenta passos para adicionar:
     *      -   Path arameters
     *      -   Notificar Error
     *      -   Build
     */
    class BuildStepBuilder implements IBuildStepBuilder<T> {

        @Override
        public IBuildStepBuilder<T> withPathParams(Map<String, ?> uriVariables) {
            builder.uriVariables.putAll(uriVariables);
            return this;
        }

        @Override
        public IBuildStepBuilder<T> withPathParam(String key, Object value) {
            if (StringUtils.hasText(key) && Objects.nonNull(value))
                builder.uriVariables.put(key, value);
            return this;
        }

        @Override
        public IBuildStepBuilder<T> withNotificarError(INotificarErro notificarErro, IErroNotificacaoDTO notificacaoDTO) {
            
            if (Objects.isNull(notificacaoDTO) || !StringUtils.hasText(notificacaoDTO.getCodigo()))
                return this;
            
            if (Objects.isNull(notificarErro))
                return this;
            
            builder.notificarErro = notificarErro;
            builder.notificacaoDTO = WebClientCustomBuilder.this.notificacaoDTO;

            return this;
        }

        @Override
        public IBuildStepBuilder<T> withToResponseEntity(Class<T> tClass) {
            builder.tClass = tClass;
            return this;
        }


        @Override
        public ResponseEntity<T> build() {
            return builder.build();
        }
    }

    public IMethodStepBuilder<T> withBaseUrlAndUri(String baseUrl, String uri) {
        this.baseUrl = baseUrl;
        this.uri = uri;
        return new MethodStepBuilder();
    }

    private WebClient getBuilder() {
        final WebClient.Builder builder = WebClient.builder();

        if (!this.filters.isEmpty()) {
            this.filters.forEach(builder::filter);
        }

        return builder
            .baseUrl(this.baseUrl)
            .build();
    }

    /**
     * @Documentation
     * @Nota:
     *      - Retorna objeto de retorno para o ResponseEntity<T>
     *
     * @see this#doWithNotificarError(Mono<ResponseEntity<T>>)
     */
    private ParameterizedTypeReference<T> bodyTypeReference() {
        return new ParameterizedTypeReference<T>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    private ResponseEntity<T> build() {
        final WebClient.RequestBodySpec bodySpec = this.getBuilder()
                .method(this.httpMethod)
                .uri(uriBuilder -> uriBuilder.path(this.uri).build(uriVariables));

        WebClient.RequestHeadersSpec<?> headersSpec;
        if (Objects.nonNull(this.body)) {
            headersSpec = bodySpec.bodyValue(this.body);
        } else {
            headersSpec = bodySpec;
        }

        final WebClient.ResponseSpec responseSpec = headersSpec.retrieve();
        final Mono<ResponseEntity<T>> responseEntityMono;

        if (Objects.isNull(tClass)) {
            responseEntityMono = responseSpec.toEntity(bodyTypeReference());
        } else {
            responseEntityMono = responseSpec.toEntity(tClass);
        }

        if (this.notificarErro != null) {
            return doWithNotificarError(responseEntityMono);
        }

        return responseEntityMono.block();
    }


    /**
     * @Documentation
     * @Nota:
     * -    Implenta condição de noticar erro.
     */
    private ResponseEntity<T> doWithNotificarError(Mono<ResponseEntity<T>> responseEntityMono) {
        return responseEntityMono.doOnError(throwable -> notificarErro.notificar(notificacaoDTO)).block();
    }
}
