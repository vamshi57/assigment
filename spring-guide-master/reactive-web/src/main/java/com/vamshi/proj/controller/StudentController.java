package com.vamshi.proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vamshi.proj.model.Student;
import com.vamshi.proj.service.StudentService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("student")
	public Mono<Student> getemployee() {
		

		return service.getStudents();
	}
}
