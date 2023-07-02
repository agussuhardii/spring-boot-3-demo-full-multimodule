package com.agussuhardi.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.agussuhardi")
@EntityScan(basePackages = {"com.agussuhardi"})
@ComponentScan(basePackages = {"com.agussuhardi"})
@EnableJpaRepositories("com.agussuhardi")

public class MainApp {

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }
}
