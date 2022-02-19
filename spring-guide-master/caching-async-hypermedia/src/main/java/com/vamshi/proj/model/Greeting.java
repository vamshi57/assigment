package com.vamshi.proj.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Greeting {
	
	private final String content;
	
	public Greeting(String content) {
	
		this.content = content;
	}
	
	

}
