package com.vamshi.proj.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vamshi.proj.model.Employee;
import com.vamshi.proj.model.Greeting;
import com.vamshi.proj.service.EmployeeService;

@RestController
@RequestMapping(value = "/")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping(value = "employee/{id}")
	@Async
	public CompletableFuture<Employee> getEmployees(@PathVariable("id") Long id) {
		System.out.println("-------------------------------------" + id + "----------------------------------");
		return CompletableFuture.completedFuture(service.getEmployeeById(id));

	}
	
	
  //hypermedia method
	@RequestMapping("/greeting/{wish}")
	public HttpEntity<?> greeting(@PathVariable("wish") String wish) {

		Greeting greeting = new Greeting(wish);
		EntityModel<Greeting> resource = EntityModel.of(greeting);
		
		resource.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(this.getClass())
				.greeting(wish))
				.withRel("greeting"));
		return new ResponseEntity<>(resource, HttpStatus.OK);
	}
}
