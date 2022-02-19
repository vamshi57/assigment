package com.vamshi.proj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.vamshi.proj.model.Employee;
import com.vamshi.proj.repo.EmployeeRepo;
@Component
public class CustomRunner  implements CommandLineRunner{
	@Autowired
	private EmployeeRepo repo;
	
	@Override
	public void run(String... args) throws Exception {
	
	  Employee emp=new Employee(5612l, "vamshi", "hyderbad", List.of(8745120l, 84512l, 451230l,8465123l));
	// repo.deleteAll();
	  repo.save(emp);
		System.out.println("successfull");
		
	}

}
