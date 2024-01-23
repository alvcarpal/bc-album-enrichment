package com.bc.album.domain.enrich;

import com.bc.album.domain.operational.Album;
import com.bc.album.domain.operational.Photo;
import java.util.List;

/**
 * Enricher interfaces provides the enrich method to apply data enrichment as deemed appropriate."
 */
public interface Enricher {

  /**
   * Enrich the data given the Album a photos list.
   *
   * @param albums The albums obtained from ApiClient Album API.
   * @param photos The photos obtaines from ApiClient Phto API.
   * @return The enriched data.
   */
  List<Album> enrich(List<Album> albums, List<Photo> photos);

}
