package com.bc.album.domain.port.in;

import com.bc.album.domain.operational.Album;
import java.util.List;

/**
 * EnrichService interface.
 * In com.bc.album.domain.port.in
 *
 * @author Álvaro Carmona
 * @since 23/01/2024
 */
public interface EnrichService {

    /**
     *  The enrich method enables the enrichment of Album data by retrieving information from
     *  the corresponding endpoints of the Album API and storing it in the database if necessary.
     *  Use persist=true if saving is required, or false otherwise.
     *
     * @return The albums' information.
     */
    List<Album> enrich(boolean persist);

}
