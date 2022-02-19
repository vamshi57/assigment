package com.vamshi.proj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.vamshi.proj.service.Producer;

@Component
public class CustomCommadLine implements CommandLineRunner{
	
	@Autowired
	private Producer producer;
	
	
	@Override
	public void run(String... args) throws Exception {
        
          producer.send("vamshi57cvbjhfgiguhoghj");
         
          
	}

}
