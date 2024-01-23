package com.bc.album.boot.spring.beans.services;

import com.bc.album.application.usescases.enrich.EnrichUseCase;
import com.bc.album.domain.port.in.EnrichService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class EnrichConfiguration {

    @Bean
    public EnrichService enrichService(RestTemplate restTemplate) {
        return new EnrichUseCase(restTemplate);
    }

}
