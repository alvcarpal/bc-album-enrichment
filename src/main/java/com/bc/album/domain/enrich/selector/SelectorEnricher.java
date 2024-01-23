package com.bc.album.domain.enrich.selector;

import com.bc.album.domain.enrich.Enricher;
import com.bc.album.domain.enrich.algorithm.AlbumEnricher;
import com.bc.album.domain.operational.Album;
import com.bc.album.domain.operational.Photo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectorEnricher {

  private static final Map<String, Enricher> enrichers;

  static {
    enrichers = new HashMap<>();
    enrichers.put("AlbumEnricher", new AlbumEnricher());
  }

  public List<Album> enriquecerDatos(List<Album> albums, List<Photo> photos, String key) {
    return enrichers.getOrDefault(key, (a, f) -> albums).enrich(albums, photos);
  }

}
