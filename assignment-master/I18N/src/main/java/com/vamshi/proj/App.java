package com.vamshi.proj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class App {
	

	public static void main(String[] args) throws Exception {
		
		 DateTimeFormatter formatter;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter Date format you want  ENGLISH,ITALIAN,GERMAN =");

		String localetyep = br.readLine();
		
		//LocalDate.parse(array[4], DateTimeFormatter.ofPattern("yyyy-MM-dd")
		if(localetyep.equalsIgnoreCase("english")) {
			formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
			System.out.println("Please Enter date in the yyyy-mm-dd format only");
		}
		else if(localetyep.equalsIgnoreCase("italian")) {
			formatter=DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ITALIAN);
			System.out.println("Please Enter date in the dd.mm.yyyy  format only");

		}
       else if(localetyep.equalsIgnoreCase("german")) {
			formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.GERMAN);	
			System.out.println("Please Enter date in the dd-mm-yyyy format only");

		}
       else {
    	   formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.getDefault());
    	   System.out.println("Please Enter date in the dd/mm/yyyy format only");
       }
		
	
		System.out.print("enter first date      :");
		System.out.println();
		LocalDate date1 =  LocalDate.parse(br.readLine(), formatter);
		System.out.println(date1);
		System.out.print("enter second date     :");
		LocalDate date2 = LocalDate.parse(br.readLine(), formatter);
		System.out.println(dateDifference(date1, date2));
		System.out.println(dateSum(date1, date2));
	}

	
	private static String dateDifference(LocalDate date1,LocalDate date2) {
		
		Period age=Period.between(date1, date2);
		return ""+age.getYears()+" "+age.getMonths()+" "+age.getDays();
		
	}
	private static String dateSum(LocalDate date1,LocalDate date2) {
	int day=date1.getDayOfMonth()+date2.getDayOfMonth();
	int month=date1.getMonthValue()+date2.getMonthValue();
	int year =date1.getYear()-date2.getYear();
	if(day>30) {
		day=day-30;
		month=month+1;
	}
	if(month>12) {
		year=year+1;
		month=month-12;
	}
	
	return ""+year+" "+month+" "+day;
	}
	
	
	
}
