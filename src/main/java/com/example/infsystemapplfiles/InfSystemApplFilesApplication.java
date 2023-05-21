package com.example.infsystemapplfiles;

import com.example.infsystemapplfiles.config.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class InfSystemApplFilesApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfSystemApplFilesApplication.class, args);
    }

}
