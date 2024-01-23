package com.bc.album.boot.spring.config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@Log4j2
@ConfigurationProperties(prefix = "com.bc.album.cfg")
public class AppConfig implements InitializingBean {

  private static AppConfig instance;

  private HttpConnectionPoolProperties httpPool;

  @Override
  public void afterPropertiesSet() throws Exception {
    init(this);
  }

  private static void init(AppConfig appConfig) {
    instance = appConfig;
  }

  /**
   * Gets the AppConfig in a static way.
   *
   * @return the app config.
   */
  public static AppConfig get() {
    return instance;
  }

}
