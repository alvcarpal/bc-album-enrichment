package com.bc.album.infrastructure.webclient.client;

import com.bc.album.application.exception.ApiExchangeException;
import com.bc.album.domain.operational.Album;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AlbumApiClientTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private AlbumApiClient client;

    @Mock
    private ResponseEntity<List<Album>> responseEntityMock;

    @Test
    public void fetchDataReturnAlbumListOkTest() {
        Mockito.doReturn(responseEntityMock).when(restTemplate).exchange("https://jsonplaceholder.typicode.com/albums",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Album>>() {
                });
        List<Album> result = client.fetchData();
        verify(restTemplate, times(1)).exchange("https://jsonplaceholder.typicode.com/albums",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Album>>() {
                });
    }

    @Test(expected = ApiExchangeException.class)
    public void fetchDataReturnKoResponseThrowApiExchangeExceptionTest() {
        List<Album> result = client.fetchData();
    }

    @Test
    public void getEntityTypeOkTest() {
        assertEquals(Album.class, client.getEntityType());
    }


}
