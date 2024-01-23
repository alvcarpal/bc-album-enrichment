package com.bc.album.infrastructure.db.springdata.repository;

import com.bc.album.domain.operational.Album;
import com.bc.album.domain.port.out.AlbumsRepository;
import com.bc.album.infrastructure.db.springdata.mapper.AlbumsDboMapper;
import com.bc.album.infrastructure.db.springdata.repository.jpa.JpaAlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * AlbumRepository interface implementation.
 * In com.bc.album.infrastructure.db.springdata.repository package.
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so.
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

}
