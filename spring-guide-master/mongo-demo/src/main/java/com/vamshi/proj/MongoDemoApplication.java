package com.vamshi.proj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vamshi.proj.model.Employee;
import com.vamshi.proj.repo.EmployeeRepo;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class MongoDemoApplication {
	
	@Autowired
	private EmployeeRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(MongoDemoApplication.class, args);
	}
	
	@GetMapping(value = "getall")
	public List<Employee> getAll(){
		System.out.println("fcgvhbjnkml");
		return repo.findAll();
	}

}
