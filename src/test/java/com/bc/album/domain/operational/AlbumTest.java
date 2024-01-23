package com.bc.album.domain.operational;

import com.bc.album.utils.ClassTest;

public class AlbumTest extends ClassTest<Album> {

   @Override
   protected Album getInstance() {
      testEquals();
      return new Album();
   }

}
