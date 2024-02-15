package br.com.ecommerce.school.processamentoms.config.custom;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface IBuildStepBuilder<T> {
    IBuildStepBuilder<T> withPathParams(Map<String, ?> uriVariables);
    IBuildStepBuilder<T> withPathParam(String key, Object value);
    IBuildStepBuilder<T> withNotificarError(INotificarErro notificarErro, IErroNotificacaoDTO erroNotificacao);
    IBuildStepBuilder<T> withToResponseEntity(Class<T> tClass);
    ResponseEntity<T> build();
}
