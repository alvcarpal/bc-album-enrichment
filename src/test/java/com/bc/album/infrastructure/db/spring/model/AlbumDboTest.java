package com.bc.album.infrastructure.db.spring.model;

import com.bc.album.infrastructure.db.springdata.model.AlbumDbo;
import com.bc.album.utils.ClassTest;

public class AlbumDboTest extends ClassTest<AlbumDbo> {

   @Override
   protected AlbumDbo getInstance() {
      testEquals();
      return new AlbumDbo();
   }

}
