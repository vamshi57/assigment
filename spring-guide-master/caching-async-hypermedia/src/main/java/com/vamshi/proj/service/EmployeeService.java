package com.vamshi.proj.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.vamshi.proj.model.Employee;

@Service
public class EmployeeService {

	@Cacheable("employee")
	public Employee getEmployeeById(Long id) {
		try {
			 System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
			Thread.sleep(100l);
			
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new Employee(40L, "vamshi", "city");
	}
	
}
