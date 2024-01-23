package com.bc.album.boot.spring.beans.services;

import com.bc.album.application.usescases.AlbumsUseCase;
import com.bc.album.domain.port.in.AlbumsService;
import com.bc.album.domain.port.out.AlbumsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlbumsConfiguration {

    @Bean
    public AlbumsService albumsService(AlbumsRepository repository) {
        return new AlbumsUseCase(repository);
    }

}
