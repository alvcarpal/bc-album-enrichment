package com.bc.album.application.usescases.album;

import com.bc.album.domain.operational.Album;
import com.bc.album.domain.port.in.AlbumsService;
import com.bc.album.domain.port.out.AlbumsRepository;
import lombok.AllArgsConstructor;
import java.util.List;

/**
 * AlbumsService interface implementation.
 * In com.bc.album.application.usescases package.
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
