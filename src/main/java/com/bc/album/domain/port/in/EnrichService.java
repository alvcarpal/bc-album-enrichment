package com.bc.album.domain.port.in;

import com.bc.album.domain.operational.Album;
import java.util.List;

/**
 * EnrichService interface.
 * In com.bc.album.domain.port.in
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so.
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
