package com.sinapsIK;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAutoConfiguration
@ComponentScan("com.sinapsIK.*")
public class RestDemoApplication {
     /* @PostConstruct
      void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC+3"));
      }*/
    public final static Logger logger = LoggerFactory.getLogger(RestDemoApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(RestDemoApplication.class, args);
    }

}
