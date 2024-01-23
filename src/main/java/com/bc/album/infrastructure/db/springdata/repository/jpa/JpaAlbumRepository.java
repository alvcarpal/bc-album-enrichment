package com.bc.album.infrastructure.db.springdata.repository.jpa;

import com.bc.album.infrastructure.db.springdata.model.AlbumDbo;
import com.bc.album.infrastructure.db.springdata.model.AlbumPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

/**
 * JpaAlbumRepository interface.
 * In com.bc.album.infrastructure.db.springdata.repository.jpa package.
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so.
 *
 * @author Álvaro Carmona
 * @since 22/01/2024
 */
public interface JpaAlbumRepository extends JpaRepository<AlbumDbo, AlbumPk> {

  @Query("SELECT DISTINCT album FROM AlbumDbo album JOIN FETCH album.photos photos")
  List<AlbumDbo> retrieveAll();

}
