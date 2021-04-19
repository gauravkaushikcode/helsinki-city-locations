package com.locations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelsinkiCityApplication {
    private static final Logger log = LoggerFactory.getLogger(HelsinkiCityApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(HelsinkiCityApplication.class, args);
    }

}
