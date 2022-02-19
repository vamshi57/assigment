package com.vamshi.proj.consumer;


import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.stereotype.Component;

import com.vamshi.proj.config.MessagingConfig;
import com.vamshi.proj.dto.OrderStatus;

@Component
public class User {

    @RabbitListener(queues = MessagingConfig.QUEUE)
    
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
    	 System.out.println("Message recieved from queue : " + orderStatus);
    }
   
}