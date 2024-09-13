package com.app.gestion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing  // //obligatoire pour @CreatedDate
public class GestionApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionApplication.class, args);
    }

}
