package com.iwbar.popa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class OpenDotaConfig {

    @Bean
    public WebClient openDotaWebClient(WebClient.Builder builder) {
        return builder
                .baseUrl("https://api.opendota.com/api")
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}