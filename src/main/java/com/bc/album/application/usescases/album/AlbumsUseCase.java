package com.bc.album.application.usescases.album;

import com.bc.album.domain.operational.Album;
import com.bc.album.domain.port.in.AlbumsService;
import com.bc.album.domain.port.out.AlbumsRepository;
import lombok.AllArgsConstructor;
import java.util.List;

/**
 * AlbumsService interface implementation.
 * In com.bc.album.application.usescases package.
 *
 * @author Álvaro Carmona
 * @since 22/01/2024
 */
@AllArgsConstructor
public class AlbumsUseCase implements AlbumsService {

    private final AlbumsRepository repository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Album> getAlbums() {
        return repository.getAlbums();
    }

}
