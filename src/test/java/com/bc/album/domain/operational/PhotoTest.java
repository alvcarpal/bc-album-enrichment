package com.bc.album.domain.operational;

import com.bc.album.utils.ClassTest;

public class PhotoTest extends ClassTest<Photo> {

   @Override
   protected Photo getInstance() {
      testEquals();
      return new Photo();
   }
   
}
