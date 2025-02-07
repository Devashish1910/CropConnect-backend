package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import io.github.cdimascio.dotenv.Dotenv;


@SpringBootApplication(scanBasePackages = "com.app")
@EnableMongoRepositories(basePackages = "com.app.repository")
public class CropConnectBackendApplication {

	public static void main(String[] args) {
		
		Dotenv dotenv = Dotenv.load();

		
		System.setProperty("spring.data.mongodb.uri", dotenv.get("MONGO_URI"));
		System.setProperty("spring.mail.username", dotenv.get("ADMIN_EMAIL"));
		System.setProperty("spring.mail.password", dotenv.get("ADMIN_PASSWORD"));
		System.setProperty("GOV_API_KEY", dotenv.get("GOV_API_KEY"));
	
//		System.setProperty("STATE_API_KEY", dotenv.get("STATE_API_KEY"));
		System.out.println("https://localhost:8080");
		SpringApplication.run(CropConnectBackendApplication.class, args);
		
	}

}
