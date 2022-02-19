package com.vamshi.proj.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vamshi.proj.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>  {
         
	Optional<User>  findByUsrMail(String usrMail);
} 
