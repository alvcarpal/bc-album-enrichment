package com.bc.album.domain.enrich.selector;

import com.bc.album.domain.enrich.Enricher;
import com.bc.album.domain.enrich.algorithm.AlbumEnricher;
import com.bc.album.domain.operational.Album;
import com.bc.album.domain.operational.Photo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SelectorEnricher class.
 * In com.bc.album.domain.enrich.selector.
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
public class SelectorEnricher {

  static final String ALBUM_ENRICHER = "AlbumEnricher";

  private static final Map<String, Enricher> enrichers;

  static {
    enrichers = new HashMap<>();
    enrichers.put(ALBUM_ENRICHER, new AlbumEnricher());
  }

  /**
   * Select the specific enrichment algorithm based on the provided key.
   */
  public List<Album> enriching(List<Album> albums, List<Photo> photos, String key) {
    return enrichers.getOrDefault(key, (a, f) -> albums).enrich(albums, photos);
  }

}
