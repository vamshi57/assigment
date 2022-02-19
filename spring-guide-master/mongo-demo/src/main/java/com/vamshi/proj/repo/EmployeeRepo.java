package com.vamshi.proj.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.vamshi.proj.model.Employee;

@Repository
public interface EmployeeRepo  extends MongoRepository<Employee, Long>{

	
	
}
