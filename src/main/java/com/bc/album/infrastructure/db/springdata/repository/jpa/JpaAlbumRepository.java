package com.bc.album.infrastructure.db.springdata.repository.jpa;

import com.bc.album.infrastructure.db.springdata.model.AlbumDbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

/**
 * JpaAlbumRepository interface.
 * In com.bc.album.infrastructure.db.springdata.repository.jpa package.
 *
 * @author Álvaro Carmona
 * @since 22/01/2024
 */
public interface JpaAlbumRepository extends JpaRepository<AlbumDbo, Integer> {

  @Query("SELECT DISTINCT album FROM AlbumDbo album JOIN FETCH album.photos photos")
  List<AlbumDbo> retrieveAll();

}
