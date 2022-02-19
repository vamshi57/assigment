package com.vamshi.library;

public class App {

	
	public static void main(String[] args) {
     //set configuration file,logoutkey,loglevel key
		
	 //
		Library.configurationDetails("/home/vvkvrk/Desktop/config_log.txt", "LOG_OUTPUT", "LOG_LEVEL");      
		Logger logger=Logger.getLogger(App.class);
		logger.debug("vamshi");
		logger.info("vamshi");
		logger.error("vamhis");
		Logger.completedToWrite();
		
		
		
	}
}
