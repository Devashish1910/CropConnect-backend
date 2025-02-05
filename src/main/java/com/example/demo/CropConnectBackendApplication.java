package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication(scanBasePackages = "com.app")
@EnableMongoRepositories(basePackages = "com.app.repository")
public class CropConnectBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CropConnectBackendApplication.class, args);
		
	}

}
