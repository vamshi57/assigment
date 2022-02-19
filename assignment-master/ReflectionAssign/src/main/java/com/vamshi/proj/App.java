package com.vamshi.proj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.LinkedList;
import java.util.List;

public class App {
	public static void main(String[] args) throws Exception {
     //create object to class
		Operation op = new Operation();

		// enter method name
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter the method name");
		String methodName = br.readLine();

		Method[] methods = Operation.class.getDeclaredMethods();
		
		Method methodwanted=null;
		Parameter[] parameters=null;
		List<Object> values=new LinkedList<>(); 

		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				methodwanted=method;
			         parameters=method.getParameters();
			}

		}
	
		if(parameters!=null) {
			for (Parameter parameter : parameters) {
				if (parameter.getType().toString().equals("int")) {
					System.out.println("enter arg with type int");
					Integer arg=Integer.parseInt(br.readLine());
					values.add(arg);
					
				}
				
				if (parameter.getType().isInstance("java.lang.String")) {
					System.out.println("enter arg with type String");
					String arg=br.readLine();
					values.add(arg);
					
				}	
			}
		}
		
		System.out.println("output for method call is ->"+ methodName+"->   "+methodwanted.invoke(op,values.get(0),values.get(1)));
		
		
	}
}
