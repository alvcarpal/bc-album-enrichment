package com.bc.album.domain.enrich;

import com.bc.album.domain.operational.Album;
import com.bc.album.domain.operational.Photo;
import java.util.List;

public interface Enricher {

  List<Album> enrich(List<Album> albums, List<Photo> photos);

}
