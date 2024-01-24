package com.bc.album.domain.enrich.algorithm;

import com.bc.album.domain.enrich.Enricher;
import com.bc.album.domain.operational.Album;
import com.bc.album.domain.operational.Photo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Enricher interface implementation.
 * In com.bc.album.domain.enrich.algorithm.
 *
 * @author Álvaro Carmona
 * @since 23/01/2024
 */
public class AlbumEnricher implements Enricher {

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Album> enrich(List<Album> albums, List<Photo> photos)  {
      Map<Integer, Album> albumMap = new HashMap<>();

      for (Album album : albums) {
          Album newAlbum = new Album();
          newAlbum.setId(album.getId());
          newAlbum.setUserId(album.getUserId());
          newAlbum.setTitle(album.getTitle());
          newAlbum.setPhotos(new ArrayList<>());
          albumMap.put(album.getId(), newAlbum);
      }

      for (Photo photo : photos) {
          Album album = albumMap.get(photo.getAlbumId());
          if (album != null) {
              album.getPhotos().add(photo);
          }
      }

      return new ArrayList<>(albumMap.values());
  }

}
