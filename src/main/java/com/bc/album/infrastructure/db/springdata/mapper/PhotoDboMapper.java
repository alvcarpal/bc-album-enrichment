package com.bc.album.infrastructure.db.springdata.mapper;

import com.bc.album.domain.operational.Photo;
import com.bc.album.infrastructure.db.springdata.model.PhotoDbo;
import org.mapstruct.Mapper;

/**
 * PhotoDboMapper interface. Mapstruct album mapper to domain.
 * In com.bc.album.infrastructure.db.springdata.mapper.
 *
 * @author Álvaro Carmona
 * @since 22/01/2024
 */
@Mapper(componentModel = "spring")
public interface PhotoDboMapper {

    /**
     * Map the given dbo photo to domain.
     * @param photo {@link PhotoDbo} object.
     * @return The mapped domain object.
     */
    Photo map(PhotoDbo photo);

    /**
     * Map the given domain photo to dbo.
     * @param photo {@link Photo} object.
     * @return The mapped dbo object.
     */
    PhotoDbo toDbo(Photo photo);

}
