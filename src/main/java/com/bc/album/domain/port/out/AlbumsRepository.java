package com.bc.album.domain.port.out;

import com.bc.album.domain.operational.Album;
import java.util.List;

/**
 * AlbumsRepository interface.
 * In com.bc.album.domain.port.out
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
public interface AlbumsRepository {

  /**
   * Serves the purpose of accessing an H2 database and retrieving comprehensive information
   * about all albums stored within the database.
   *
   * @return The albums' information.
   */
  List<Album> getAlbums();

  /**
   * Save All using L1 cache
   */
  List<Album> saveAll(List<Album> albums);

}
