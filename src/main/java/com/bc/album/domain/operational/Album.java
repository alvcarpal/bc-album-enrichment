package com.bc.album.domain.operational;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The class "Album" represents the concept of an album, which can contain
 * N photos stored in the ArrayList data structure.
 */
@Data
@NoArgsConstructor
public class Album {
  private Integer id;
  private Integer userId;
  private String title;
  private List<Photo> photos = new ArrayList<>();
}
