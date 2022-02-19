package com.vamshi.proj;

public class ConfiguarationFileParser {

	
	public static void main(String[] args) {

		
		ConfigReader confiReader=new ConfigReader("/home/vvkvrk/Desktop/config.txt");
		confiReader.fileReader();
		System.out.println(confiReader.getValueBykey("name1"));
	   
	}
	
}
