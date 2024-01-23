package com.bc.album.infrastructure.db.springdata.mapper;

import com.bc.album.domain.operational.Photo;
import com.bc.album.infrastructure.db.springdata.model.AlbumDbo;
import com.bc.album.infrastructure.db.springdata.model.PhotoDbo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * PhotoDboMapper interface. Mapstruct album mapper to domain.
 * In com.bc.album.infrastructure.db.springdata.mapper.
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
@Mapper(componentModel = "spring")
public interface PhotoDboMapper {

    /**
     * Map the given dbo photo to domain.
     * @param photo {@link AlbumDbo} object.
     * @return The mapped dto object.
     */
    @Mapping(target = "id", source = "pk.id")
    Photo map(PhotoDbo photo);

}
