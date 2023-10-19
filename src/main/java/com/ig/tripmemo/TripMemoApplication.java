package com.ig.tripmemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.ig.tripmemo.repository.entity")
public class TripMemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TripMemoApplication.class, args);
    }

}
