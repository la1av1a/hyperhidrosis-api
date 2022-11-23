package com.example.boardboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BoardboardApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(BoardboardApplication.class)
            .properties(
                "spring.config.location=" +
                    "classpath:/application.properties" +
                    ", file:/etc/config/application-database.properties"
            )
            .run(args);
    }
}
