package com.bc.album.boot.spring.config;

import lombok.Data;

/**
 * Http pool properties
 *
 * @author Álvaro Carmona
 * @since 23/01/2024
 */
@Data
public class HttpConnectionPoolProperties {

  private Integer maxPerRoute;
  private Integer maxTotal;
  private Integer connectionRequestTimeout;
  private Integer connectTimeout;
  private Integer connectTimeToLive;
  private Integer socketTimeout;

}
