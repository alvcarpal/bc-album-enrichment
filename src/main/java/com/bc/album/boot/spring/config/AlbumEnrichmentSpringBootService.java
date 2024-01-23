package com.bc.album.boot.spring.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TemplateSpringBootService class.
 * Main method.
 * In com.bc.album.boot.spring.config package.
 *
 * @author Álvaro Carmona
 * @since 22/01/2024
 */
@SpringBootApplication(scanBasePackages = {
        "com.bc.album.infrastructure",
        "com.bc.album.application",
        "com.bc.album.boot"
})
public class AlbumEnrichmentSpringBootService {

    /**
     * Main method.
     *
     * @param args a {@link String} object.
     */
    public static void main(String[] args) {
        SpringApplication.run(AlbumEnrichmentSpringBootService.class, args);
    }

}

