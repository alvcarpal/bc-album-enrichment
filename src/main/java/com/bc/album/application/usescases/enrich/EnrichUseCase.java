package com.bc.album.application.usescases.enrich;

import com.bc.album.domain.enrich.selector.SelectorEnricher;
import com.bc.album.domain.operational.Album;
import com.bc.album.domain.operational.Photo;
import com.bc.album.domain.port.in.EnrichService;
import com.bc.album.domain.port.out.AlbumsRepository;
import com.bc.album.infrastructure.webclient.ApiClient;
import com.bc.album.infrastructure.webclient.factory.ApiClientFactory;
import lombok.AllArgsConstructor;
import org.springframework.web.client.RestTemplate;
import java.util.List;

/**
 * EnrichUseCase interface implementation.
 * In com.bc.album.application.usescases package.
 *
 * @author Álvaro Carmona
 * @since 23/01/2024
 */
@AllArgsConstructor
public class EnrichUseCase implements EnrichService {

    private final RestTemplate restTemplate;

    private final SelectorEnricher selector;

    private final AlbumsRepository repository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Album> enrich(boolean persist) {
        List<Album> albums = selector.enriching(retrieveAlbumApiData(), retrievePhotoApiData(), "AlbumEnricher");
        return persist ? repository.saveAll(albums) : albums;
    }

    /**
     * Retrieves information from the Albums API by making a REST template call to the configured URL
     */
    private List<Album> retrieveAlbumApiData() {
        ApiClient<Album> albumApiClient = ApiClientFactory.createApiClient(Album.class, restTemplate);
        return albumApiClient.fetchData();
    }

    /**
     * Retrieves information from the Photos API by making a REST template call to the configured URL
     */
    private List<Photo> retrievePhotoApiData() {
        ApiClient<Photo> photoApiClient = ApiClientFactory.createApiClient(Photo.class, restTemplate);
        return photoApiClient.fetchData();
    }

}
