package com.bc.album.domain.port.in;

import com.bc.album.domain.operational.Album;
import java.util.List;

/**
 * AlbumsService interface.
 * In com.bc.album.domain.port.in
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
public interface AlbumsService {

  /**
   *  Retrieves information about all albums along with their associated photos.
   *  This method provides a comprehensive view of the entire collection of albums
   *  and the photos contained within each album.
   *
   * @return The albums' information.
   */
  List<Album> getAlbums();

}
