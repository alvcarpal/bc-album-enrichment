package com.bc.album.application.usescases.enrich;

import com.bc.album.domain.operational.Album;
import com.bc.album.domain.operational.Photo;
import com.bc.album.domain.port.in.EnrichService;
import com.bc.album.infrastructure.webclient.ApiClient;
import com.bc.album.infrastructure.webclient.factory.ApiClientFactory;
import lombok.AllArgsConstructor;
import org.springframework.web.client.RestTemplate;
import java.util.List;

/**
 * EnrichUseCase interface implementation.
 * In com.bc.album.application.usescases package.
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so.
 *
 * @author Álvaro Carmona
 * @since 23/01/2024
 */
@AllArgsConstructor
public class EnrichUseCase implements EnrichService {

    private final RestTemplate restTemplate;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Album> enrich(boolean persist) {
        ApiClient<Album> albumApiClient = ApiClientFactory.createApiClient(Album.class, restTemplate);
        List<Album> albums = albumApiClient.fetchData();

        ApiClient<Photo> photoApiClient = ApiClientFactory.createApiClient(Photo.class, restTemplate);
        List<Photo> photos = photoApiClient.fetchData();
        return null;
    }

}