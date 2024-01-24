package com.bc.album.infrastructure.db.springdata.repository;

import com.bc.album.domain.operational.Album;
import com.bc.album.domain.port.out.AlbumsRepository;
import com.bc.album.infrastructure.db.springdata.mapper.AlbumsDboMapper;
import com.bc.album.infrastructure.db.springdata.repository.jpa.JpaAlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * AlbumRepository interface implementation.
 * In com.bc.album.infrastructure.db.springdata.repository package.
 *
 * @author Álvaro Carmona
 * @since 22/01/2024
 */
@Component
@RequiredArgsConstructor
public class CustomAlbumRepository implements AlbumsRepository {

    private final JpaAlbumRepository repository;

    private final AlbumsDboMapper mapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Album> getAlbums() {
        return mapper.map(repository.retrieveAll());
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public List<Album> saveAll(List<Album> albums) {
        return mapper.map(repository.saveAll(mapper.toDbo(albums)));
    }

}
