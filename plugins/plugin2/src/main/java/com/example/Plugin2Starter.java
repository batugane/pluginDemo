package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example", "org.laxture.sbp.*", "org.laxture.sbp.spring.boot.*"})
public class Plugin2Starter {
    public static void main(String[] args) {
        SpringApplication.run(Plugin2Starter.class, args);
    }
}