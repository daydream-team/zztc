package com.daydream.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ServletComponentScan
@ComponentScan(basePackages = {"com.daydream.console"})
@ImportResource("classpath*:spring.xml")
@EnableAutoConfiguration
@SpringBootApplication
public class Application {

  /**
   * logger
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) throws Exception {
    LOGGER.info("daydream console starting......");

    try {
      SpringApplication.run(Application.class, args);
    } catch (Exception e) {
      e.printStackTrace();
    }
    LOGGER.info("daydream console started!");
  }

}
