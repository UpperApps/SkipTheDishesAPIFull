package com.skipthedishes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SpringBootApplication
public class SkipTheDishesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkipTheDishesApiApplication.class, args);
    }

    // The method bellow is only necessary from Spring Boot v2.0 onwards.
    // From Spring Boot 2.0 onwards the security package requires that the password be hashed, which is not done in this implementation.
    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
