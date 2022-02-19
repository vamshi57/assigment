package com.vamshi.proj.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vamshi.proj.model.User;

@Service
public interface UserService {
	Long saveUser(User user);
	Optional<User> findByEmai(String email);
}
