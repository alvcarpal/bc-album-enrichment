package com.bc.album.infrastructure.db.springdata.mapper;

import com.bc.album.domain.operational.Album;
import com.bc.album.infrastructure.db.springdata.model.AlbumDbo;
import org.mapstruct.Mapper;
import java.util.List;

/**
 * AlbumsDboMapper interface. Mapstruct album mapper to domain.
 * In com.bc.album.infrastructure.db.springdata.mapper.
 *
 * @author Álvaro Carmona
 * @since 22/01/2024
 */
@Mapper(componentModel = "spring", uses = PhotoDboMapper.class)
public interface AlbumsDboMapper {

    /**
     * Map the given dbo album to domain.
     * @param album {@link AlbumDbo} object.
     * @return The mapped dto object.
     */
    Album map(AlbumDbo album);

    /**
     * Map the given dbo album list to domain list.
     * @param albums list of a {@link AlbumDbo} objects.
     * @return The mapped dto list.
     */
    List<Album> map(List<AlbumDbo> albums);

    /**
     * Map the given domain album to dbo.
     * @param album {@link Album} object.
     * @return The mapped dto object.
     */
    AlbumDbo toDbo(Album album);

    /**
     * Map the given domain album list to dbo list.
     * @param albums list of a {@link Album} objects.
     * @return The mapped dto list.
     */
    List<AlbumDbo> toDbo(List<Album> albums);

}
