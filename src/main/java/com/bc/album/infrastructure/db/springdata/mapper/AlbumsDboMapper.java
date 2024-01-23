package com.bc.album.infrastructure.db.springdata.mapper;

import com.bc.album.domain.operational.Album;
import com.bc.album.infrastructure.db.springdata.model.AlbumDbo;
import org.mapstruct.Mapper;
import java.util.List;

/**
 * AlbumsDboMapper interface. Mapstruct album mapper to domain.
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
public interface AlbumsDboMapper {

    /**
     * Map the given dbo album to domain.
     * @param album {@link AlbumDbo} object.
     * @return The mapped dto object.
     */
    Album map(AlbumDbo album);

    /**
     * Map the given dbo album list to domain list.
     * @param albums list of a {@link Album} objects.
     * @return The mapped dto list.
     */
    List<Album> map(List<AlbumDbo> albums);

}
