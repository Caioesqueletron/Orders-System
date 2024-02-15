package br.com.ecommerce.school.pedidosms.config.custom;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface IBodyStepBuilder<T> {
    IBodyStepBuilder<T> withPathParams(Map<String, ?> uriVariables);
    IBodyStepBuilder<T> withPathParam(String key, Object value);
    IBuildStepBuilder<T> withBody(Object body);
    IBuildStepBuilder<T> withNotificarError(INotificarErro notificarErro, IErroNotificacaoDTO notificacaoDTO);
    ResponseEntity<T> build();
}
