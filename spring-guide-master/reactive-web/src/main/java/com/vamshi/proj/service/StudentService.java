package com.vamshi.proj.service;

import org.springframework.stereotype.Service;

import com.vamshi.proj.model.Student;

import reactor.core.publisher.Mono;


@Service
public class StudentService {

	public Mono<Student> getStudents() {
		try {
			Thread.sleep(100l);
		}catch (InterruptedException e) {
			
			
			e.printStackTrace();
		}
		
		return  Mono.just(new Student(1222l, "vaksb", "hvbjn", "gcvhbjnk"));
		
	}
	
	
}
