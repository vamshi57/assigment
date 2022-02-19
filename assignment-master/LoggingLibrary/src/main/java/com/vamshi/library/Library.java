package com.vamshi.library;

import java.io.FileWriter;
import java.util.Set;

import com.vamshi.configfilereader.ConfigReader;

public class Library {
	private static String logOutputfile="";
	
	private Library() {
		
	}
	
 
	public static void configurationDetails(String fileLocation,String logOutputfile,String logLevelKey)  {
		
	
		ConfigReader reader=new ConfigReader(fileLocation);
		reader.fileReader();
		Library.logOutputfile=reader.getValueBykey(logOutputfile);
  		Logger.levelSetter(reader.getValueBykey(logLevelKey).toUpperCase());
	}
	
	public static void writer(Set<String> details) {
		 try ( FileWriter myWriter = new FileWriter(logOutputfile)){
	           
	           for (String st : details) {
	        	   myWriter.write(st);
	        	   myWriter.append("\n");  
			   }
	          
	        } catch (Exception e) {
	            System.out.println(e);
	        }
		
		
	}
	
}
