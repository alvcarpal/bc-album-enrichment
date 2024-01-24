package com.bc.album.infrastructure.rest.spring.mapper;

import com.bc.album.domain.operational.Album;
import com.bc.album.infrastructure.rest.spring.dto.AlbumDto;
import org.mapstruct.Mapper;
import java.util.List;

/**
 * AlbumsMapper interface. Mapstruct album mapper to dto.
 * In com.bc.album.infrastructure.rest.spring.mapper
 *
 * @author Álvaro Carmona
 * @since 22/01/2024
 */
@Mapper(componentModel = "spring")
public interface AlbumsMapper {

    /**
     * Map the given domain album to dto.
     * @param album {@link Album} object.
     * @return The mapped dto object.
     */
    AlbumDto map(Album album);

    /**
     * Map the given domain album list to dto list.
     * @param albums list of a {@link Album} objects.
     * @return The mapped dto list.
     */
    List<AlbumDto> map(List<Album> albums);
}

