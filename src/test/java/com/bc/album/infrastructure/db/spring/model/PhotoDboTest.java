package com.bc.album.infrastructure.db.spring.model;

import com.bc.album.infrastructure.db.springdata.model.PhotoDbo;
import com.bc.album.utils.ClassTest;

public class PhotoDboTest extends ClassTest<PhotoDbo> {

   @Override
   protected PhotoDbo getInstance() {
      testEquals();
      return new PhotoDbo();
   }

}
