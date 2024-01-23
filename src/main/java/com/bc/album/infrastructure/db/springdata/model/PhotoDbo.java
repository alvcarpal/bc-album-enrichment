package com.bc.album.infrastructure.db.springdata.model;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The class 'Photo' represents the concept of a photo, identified on an album by its album ID.
 */
@Data
@Entity
@Table(name = "photo")
public class PhotoDbo extends Audit{

  @EmbeddedId
  private PhotoPk pk;

  @Column(name = "album_id")
  private Integer albumId;

  @Column(name = "title")
  private String title;

  @Column(name = "url")
  private String url;

  @Column(name = "thumbnail_url")
  private String thumbnailUrl;

}
