package com.bc.album.domain.enrich.algorithm;

import com.bc.album.domain.operational.Album;
import com.bc.album.domain.operational.Photo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AlbumEnricherTest {

  private static final int SIZE = 1;

  private AlbumEnricher enricher;

  @Mock
  private Album album;

  @Mock
  private Photo photo;

  @Before
  public void setUp() {
    enricher = new AlbumEnricher();
  }

  @Test
  public void enrichingWhenAlbumIdAreNotEqualOkTest() {
    List<Album> albums = enricher.enrich(List.of(album), List.of(photo));
    assertEquals(SIZE, albums.size());
  }

  @Test
  public void enrichingWhenAlbumIdAreEqualOkTest() {
    List<Album> albums = enricher.enrich(List.of(album), List.of(photo, photo));
    assertEquals(SIZE, albums.size());
  }

}
