package com.bc.album.boot.spring.beans.services;

import com.bc.album.application.usescases.enrich.EnrichUseCase;
import com.bc.album.domain.enrich.selector.SelectorEnricher;
import com.bc.album.domain.port.in.EnrichService;
import com.bc.album.domain.port.out.AlbumsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class EnrichConfiguration {

    /**
     * Bean enrich service.
     *
     * @param restTemplate Rest template bean.
     * @param selector Selector enricher bean.
     * @return The created object.
     */
    @Bean
    public EnrichService enrichService(RestTemplate restTemplate, SelectorEnricher selector, AlbumsRepository repository) {
        return new EnrichUseCase(restTemplate, selector, repository);
    }

    /**
     * Bean selector enricher.
     *
     * @return The created object.
     */
    @Bean
    public SelectorEnricher selectorEnricher() {
        return new SelectorEnricher();
    }

}
