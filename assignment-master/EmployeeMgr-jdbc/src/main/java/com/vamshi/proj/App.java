package com.vamshi.proj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class App {
	public static void main(String[] args){
		List<Employee> employees = new ArrayList<>();
		

		try (BufferedReader br=new BufferedReader(new FileReader("/home/vvkvrk/Desktop/employees.txt"));){
			String strLine;	
			while ((strLine = br.readLine()) != null) {
				if (!strLine.trim().equals("")) {
					Employee emp = getListEmployees(strLine);
					employees.add(emp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (employees.isEmpty()) {
			System.out.println("NOt Record Found");
		} else {
			// save employees
			if (Dao.save(employees) >= 1) {
				System.out.println("Recorders saved Successfully");
			} else {
				System.out.println("Not saved ");
			}
		}
	}

	private static Employee getListEmployees(String str) {
		Employee emp = new Employee();
		String[] array = str.split(",");
		if (array.length == 5) {
			emp.setFirstName(array[0]);
			emp.setLastName(array[1]);
			emp.setAge(Integer.parseInt(array[2]));
			if (array[3].equalsIgnoreCase(Gender.FEMALE.toString())) {
				emp.setGender(Gender.FEMALE);
			}
			if (array[3].equalsIgnoreCase(Gender.MALE.toString())) {
				emp.setGender(Gender.MALE);
			}
			emp.setDateOfJoining(LocalDate.parse(array[4], DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		}
		return emp;

	}
}
