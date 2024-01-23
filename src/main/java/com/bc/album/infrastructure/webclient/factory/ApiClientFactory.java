package com.bc.album.infrastructure.webclient.factory;

import com.bc.album.domain.operational.Album;
import com.bc.album.domain.operational.Photo;
import com.bc.album.infrastructure.webclient.ApiClient;
import com.bc.album.infrastructure.webclient.client.AlbumApiClient;
import com.bc.album.infrastructure.webclient.client.PhotoApiClient;
import org.springframework.web.client.RestTemplate;

/**
 * Api client Factory class.
 */
public class ApiClientFactory {

    /**
     * Instantiate the concrete ApiClient depends on the Class type.
     */
    public static <T> ApiClient<T> createApiClient(Class<T> entityType, RestTemplate restTemplate) {
        if (entityType == Album.class) {
            return (ApiClient<T>) new AlbumApiClient(restTemplate);
        } else if (entityType == Photo.class) {
            return (ApiClient<T>) new PhotoApiClient(restTemplate);
        } else {
            throw new IllegalArgumentException("Unsupported entity type");
        }
    }

}
