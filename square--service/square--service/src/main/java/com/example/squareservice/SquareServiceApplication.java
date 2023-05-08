package com.example.squareservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories
@EnableScheduling
public class SquareServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SquareServiceApplication.class, args);
	}

}
