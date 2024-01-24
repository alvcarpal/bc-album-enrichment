package com.bc.album.domain.port.in;

import com.bc.album.domain.operational.Album;
import java.util.List;

/**
 * AlbumsService interface.
 * In com.bc.album.domain.port.in
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
