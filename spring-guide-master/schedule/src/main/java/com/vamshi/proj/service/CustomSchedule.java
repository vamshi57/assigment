package com.vamshi.proj.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CustomSchedule {

	//@Scheduled(cron = "* * * * * *")
	//@Scheduled(fixedRate = 1000l)
//	@Scheduled(cron="*/10 * * * * *")
//	@Scheduled(cron = "0 * * * * *")
	//@Scheduled(fixedDelay = 10l)
	@Scheduled(fixedRate = 1000l)  //every seconde fixed rate
	
	public void message() {
		System.out.println(" "+new Date() );
	}
}
