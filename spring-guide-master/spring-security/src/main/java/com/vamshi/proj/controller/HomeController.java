package com.vamshi.proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vamshi.proj.model.User;
import com.vamshi.proj.repo.UserRepo;
import com.vamshi.proj.service.UserService;

@RestController

@RequestMapping("/")
public class HomeController {
	@Autowired
	private UserService service;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@PostMapping(value = "/user/register")
	public ResponseEntity<String> getRegistration(@RequestBody User user){
		    service.saveUser(user);
        return 	ResponseEntity.ok("success");
	}
	
	@GetMapping(value = "/emp")
	public ResponseEntity<String> employee()
	{	
		return ResponseEntity.ok("your employee");
		
	}
	
	@GetMapping(value = "/admin")
	public ResponseEntity<String> admin()
	{	
		return ResponseEntity.ok("your admin");
		
	}
	
	
	

	
}