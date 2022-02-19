package com.vamshi.proj.producer;

import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vamshi.proj.config.MessagingConfig;
import com.vamshi.proj.dto.Order;
import com.vamshi.proj.dto.OrderStatus;

@RestController
@CrossOrigin(origins = "http:/localhost:8080/")
@RequestMapping("/")
public class OrderPublisher {
  
	@Autowired
	private RabbitTemplate template;
	
	@PostMapping(value = "/{RestaurentName}" )
	public String bookOrder(@RequestBody Order order ,@PathVariable("RestaurentName") String restaurentName) {
		
		order.setOrderId(UUID.randomUUID().toString());
		OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "order placed succesfully in " + restaurentName);
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, orderStatus);
        
        return "Success !!";
		
	}
	
	  
}
