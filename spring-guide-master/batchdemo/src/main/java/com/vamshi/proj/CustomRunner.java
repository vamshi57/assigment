package com.vamshi.proj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.vamshi.proj.model.ReaderIO;
import com.vamshi.proj.repo.Repo;

//@Component
public class CustomRunner implements CommandLineRunner{
	
	@Autowired
	private  Repo repo;
	
	@Override
	public void run(String... args) throws Exception {
		 
		ReaderIO reader=new ReaderIO();
		
		reader.setFirstName("vamshi");
		reader.setLastName("krishna");
		
		reader.setRandomNum(String.valueOf(Math.random()).substring(3, 8));
		
		repo.save(reader);
		repo.save(reader);
		repo.save(reader);
		repo.save(reader);
		repo.save(reader);
		repo.save(reader);
	}
	
	
}
