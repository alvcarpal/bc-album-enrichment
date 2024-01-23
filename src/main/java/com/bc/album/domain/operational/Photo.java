package com.bc.album.domain.operational;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The class 'Photo' represents the concept of a photo, identified on an album by its album ID.
 */
@Data
@NoArgsConstructor
public class Photo {
  private int albumId;
  private int id;
  private String url;
  private String thumbnailUrl;
}
