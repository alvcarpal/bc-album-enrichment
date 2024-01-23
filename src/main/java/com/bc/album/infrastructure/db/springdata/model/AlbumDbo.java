package com.bc.album.infrastructure.db.springdata.model;

import lombok.Data;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import java.util.ArrayList;
import java.util.List;

/**
 * The class "Album" represents the concept of an album, which can contain
 *  N photos stored in the ArrayList data structure.
 */
@Data
@Entity
@Table(name = "album")
public class AlbumDbo extends Audit{

  @EmbeddedId
  private AlbumPk pk;

  @Column(name = "user_id")
  private Integer userId;

  @Column(name = "title")
  private String title;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "albumId", fetch = FetchType.EAGER, orphanRemoval = true)
  private List<PhotoDbo> photos = new ArrayList<>();

  @Version
  @Column(name = "version")
  private Integer version;

}
