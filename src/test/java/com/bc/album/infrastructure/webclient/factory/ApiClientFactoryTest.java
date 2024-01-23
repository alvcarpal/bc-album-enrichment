package com.bc.album.infrastructure.webclient.factory;

import com.bc.album.domain.operational.Album;
import com.bc.album.domain.operational.Photo;
import com.bc.album.infrastructure.db.springdata.model.PhotoDbo;
import com.bc.album.infrastructure.webclient.ApiClient;
import com.bc.album.infrastructure.webclient.client.AlbumApiClient;
import com.bc.album.infrastructure.webclient.client.PhotoApiClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ApiClientFactoryTest {

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void createApiCliente_returnAlbumApiClient() {
        Class<Album> entityType = Album.class;
        ApiClient<Album> apiClient = ApiClientFactory.createApiClient(entityType, restTemplate);
        assertTrue(apiClient instanceof AlbumApiClient);
    }

    @Test
    public void createApiClient_returnPhotoApiClient() {
        Class<Photo> entityType = Photo.class;
        ApiClient<Photo> apiClient = ApiClientFactory.createApiClient(entityType, restTemplate);
        assertTrue(apiClient instanceof PhotoApiClient);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createApiClient_throwException() {
        Class<PhotoDbo> entityType = PhotoDbo.class;
        ApiClient<PhotoDbo> apiClient = ApiClientFactory.createApiClient(entityType, restTemplate);
    }

}
