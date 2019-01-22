package com.mpusinhol.clientapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {
            "com.mpusinhol.clientapi.domain"
            })
@EnableJpaRepositories(basePackages = {
            "com.mpusinhol.clientapi.repository"
            })
public class ClientApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApiApplication.class, args);
	}

}

