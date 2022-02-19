package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("api/v1")

public class Microservice01Application {

	public static void main(String[] args) {
		SpringApplication.run(Microservice01Application.class, args);
	}
	
	@GetMapping(value = "/")
	public String getWelcome() {
		return "welcome to microservice";
		
	}


}
