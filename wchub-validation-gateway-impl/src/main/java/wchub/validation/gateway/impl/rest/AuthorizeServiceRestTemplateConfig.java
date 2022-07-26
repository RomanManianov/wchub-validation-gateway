package wchub.validation.gateway.impl.rest;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.ExtractingResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AuthorizeServiceRestTemplateConfig {

    @Bean
    @Primary
    @Qualifier("authorizeServiceRestTemplate")
    public RestTemplate authorizeServiceRestTemplate(RestTemplateBuilder builder) {
        HttpClient httpClient = HttpClients.custom()
                .useSystemProperties()
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);

        return builder
                .errorHandler(new ExtractingResponseErrorHandler())
                .requestFactory(() -> requestFactory)
                .build();
    }
}
