package br.com.ecommerce.school.processamentoms.config.custom;

import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

public interface IMethodStepBuilder<T> {
    IMethodStepBuilder<T> filter(ExchangeFilterFunction filter);
    IMethodStepBuilder<T> filters(List<ExchangeFilterFunction> filters);
    IBodyStepBuilder<T> withPut();
    IBuildStepBuilder<T> withGet();
    IBodyStepBuilder<T> withPost();
    WebClient getWebClient();
}
