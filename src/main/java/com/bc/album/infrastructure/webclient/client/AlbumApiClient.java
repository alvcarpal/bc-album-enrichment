package com.bc.album.infrastructure.webclient.client;

import com.bc.album.application.exception.ApiExchangeException;
import com.bc.album.domain.operational.Album;
import com.bc.album.infrastructure.webclient.ApiClient;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.List;

/**
 * Class to implement {@link com.bc.album.infrastructure.webclient.ApiClient} interface methods.
 */
@Log4j2
@AllArgsConstructor
public class AlbumApiClient implements ApiClient<Album> {

    private RestTemplate restTemplate;

    @Override
    public List<Album> fetchData() {
        try {
            ResponseEntity<List<Album>> response =
                    restTemplate.exchange("https://jsonplaceholder.typicode.com/albums",
                            HttpMethod.GET, null, new ParameterizedTypeReference<List<Album>>() {
                            });
            return response.getBody();
        } catch (Exception e) {
            log.warn("Exception contacting to GET Album API", e);
            throw new ApiExchangeException("Album", e);
        }
    }

    @Override
    public Class<Album> getEntityType() {
        return Album.class;
    }

}
