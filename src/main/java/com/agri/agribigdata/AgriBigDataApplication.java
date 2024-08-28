package com.agri.agribigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.agri.agribigdata")
public class AgriBigDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgriBigDataApplication.class, args);
    }

}
