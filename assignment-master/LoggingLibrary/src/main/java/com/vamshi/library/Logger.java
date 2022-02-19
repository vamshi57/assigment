package com.vamshi.library;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Logger {
	private static LinkedHashMap<LogLevels, Boolean> levels=new LinkedHashMap<>();
	private static Set<String> logs=new LinkedHashSet<>();
	
	static {
		levels.put(LogLevels.TRACE, false);
		levels.put(LogLevels.DEBUG, false);
		levels.put(LogLevels.INFO, false);
		levels.put(LogLevels.WARN, false);	
		levels.put(LogLevels.ERROR,false);
	}
	
	public static Logger getLogger(Class<?> clazz) {
		return new Logger();
	}
	
	
	
	public static void levelSetter(String level) {
		boolean found=false;
		for (Map.Entry<LogLevels, Boolean> entry : levels.entrySet()) {
			
		    if(entry.getKey().toString().equalsIgnoreCase(level)) {
		    	found=true;
		    	levels.put(entry.getKey(), true);
		    }
		    if (found) {
		    	levels.put(entry.getKey(), true);
			}
		}
		System.out.println(levels);
	}
	
	public void trace(String message) {
		if(levels.get(LogLevels.TRACE).booleanValue()) {
		logCommon(LogLevels.TRACE.toString(), message);
		}
	}
	public void debug(String message) {
		if(levels.get(LogLevels.DEBUG).booleanValue()) {
		logCommon(LogLevels.DEBUG.toString(), message);
		}
	}
	public void info(String message) {
		if(levels.get(LogLevels.INFO).booleanValue()) {
		logCommon(LogLevels.INFO.toString(), message);
		}
	}
	
	
	public void warn(String message) {
		if(levels.get(LogLevels.WARN).booleanValue()) {
		logCommon(LogLevels.WARN.toString(), message);
		}
	}
	public void error(String message) {
		if(levels.get(LogLevels.ERROR).booleanValue()) {
		logCommon(LogLevels.ERROR.toString(), message);
		}
	}
	
	
	private static void logCommon(String logLevel,String message ) {
		Thread current = Thread.currentThread();
	    StackTraceElement[] stack = current.getStackTrace();
		
		String log="";
		log=log+" "+current.getId();
		log=log+" "+LocalDateTime.now();
		log=log+" "+logLevel;
		log= log+" "+stack[3].getClassName();
        log=log+" "+stack[3].getMethodName();
         log=log+" "+stack[3].getLineNumber();
         log=log+" "+message;
         System.out.println(log);
      logs.add(log);
		
	}
	public static void completedToWrite() {
		Library.writer(logs);
		
	}

}
