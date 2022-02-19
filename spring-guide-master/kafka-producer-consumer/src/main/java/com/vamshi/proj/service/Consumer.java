package com.vamshi.proj.service;

import java.util.Date;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.stereotype.Component;


@Component
public class Consumer {

	
	@KafkaListener(topics = "${my.kafka-tpc-name}",groupId = "group-id")
	public void readDataFromkafka(String message) {
		
		System.out.println(message +"  "+new Date());
	}
}
