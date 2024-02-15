package br.com.ecommerce.school.produtosms.config;

import co.elastic.apm.attach.ElasticApmAttacher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ElasticAPMConfig {
    private static final String SERVER_URL_KEY = "server_url";
    @Value("${elastic.apm.server-url}")
    private String serverUrl;


    @PostConstruct
    public void init() {

        Map<String, String> apmProps = new HashMap<>(6);
        apmProps.put(SERVER_URL_KEY, serverUrl);
        ElasticApmAttacher.attach(apmProps);
    }
}

