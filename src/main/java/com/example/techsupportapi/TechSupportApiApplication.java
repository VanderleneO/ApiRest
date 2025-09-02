package com.example.techsupportapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main Spring Boot application class.
 * Provides the entry point for the application and autoconfiguration.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.example.techsupportapi")
public class TechSupportApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechSupportApiApplication.class, args);
    }
}
