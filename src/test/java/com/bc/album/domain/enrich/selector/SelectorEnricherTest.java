package com.bc.album.domain.enrich.selector;

import com.bc.album.domain.operational.Album;
import com.bc.album.domain.operational.Photo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SelectorEnricherTest {

  private static final int SIZE = 1;

  @Mock
  private Album album;

  @Mock
  private Photo photo1;

  @Mock
  private Photo photo2;

  @Test
  public void enrichingWithNotExistingKeyReturnDefaultValueAlbumsOkTest() {
      SelectorEnricher selector = new SelectorEnricher();
      List<Album> enriched = selector.enriching(List.of(album), List.of(photo1), "key");
      assertEquals(SIZE, enriched.size());
  }

    @Test
    public void enrichingWithExistingKeyCallEnricherOkTest() {
        SelectorEnricher selector = new SelectorEnricher();
        List<Album> enriched = selector.enriching(List.of(album), List.of(photo1, photo2), "AlbumEnricher");
        assertEquals(SIZE, enriched.size());
        assertEquals(2, enriched.get(0).getPhotos().size());
    }

}
