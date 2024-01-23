package com.bc.album.infrastructure.webclient.client;

import com.bc.album.application.exception.ApiExchangeException;
import com.bc.album.domain.operational.Photo;
import com.bc.album.infrastructure.webclient.ApiClient;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Log4j2
@AllArgsConstructor
public class PhotoApiClient implements ApiClient<Photo> {

    private RestTemplate restTemplate;

    @Override
    public List<Photo> fetchData() {
        try {
            ResponseEntity<List<Photo>> response =
                    restTemplate.exchange("https://jsonplaceholder.typicode.com/photos",
                            HttpMethod.GET, null, new ParameterizedTypeReference<List<Photo>>() {
                            });
            return response.getBody();
        } catch (Exception e) {
            log.warn("Exception contacting to GET Photo API", e);
            throw new ApiExchangeException("Photo", e);
        }
    }

    @Override
    public Class<Photo> getEntityType() {
        return Photo.class;
    }

}