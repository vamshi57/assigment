package com.vamshi.proj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {
  
	@Value("${my.kafka-tpc-name}")
	private String topic;
	
	@Autowired
	private KafkaTemplate<String, String> template;
	
	public void send(String message) {
		System.out.println("send messgae to kafka");
		template.send(topic, message);
		System.out.println("successfully sent message");
		
	}
	
}
