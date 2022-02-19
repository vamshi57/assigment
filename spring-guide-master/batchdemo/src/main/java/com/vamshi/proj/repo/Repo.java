package com.vamshi.proj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vamshi.proj.model.ReaderIO;

@Repository
public interface Repo extends JpaRepository<ReaderIO, Long>{
	
	

}
