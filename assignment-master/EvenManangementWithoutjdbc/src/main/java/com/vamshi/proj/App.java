package com.vamshi.proj;

import java.time.LocalDate;


public class App {

	public static void main(String[] args)  {
		int id=Store.getId();
		System.out.println(id);
		space(2);
		System.out.println("save");
		System.out.println(Store.insertEvent(
				new Event(0, "vamshi", EventType.BRITHDAY, LocalDate.of(1996, 12, 8)))?"successfully inserted":"Not inserted");
		
		//get some ids
		
		space(2);
		
		System.out.println("update");
		System.out.println(Store.updateEvent(
				new Event(0, "vamshi", EventType.BRITHDAY, LocalDate.of(1996, 12, 8)))?"successfully updated":"Not updated");
		space(2);
		//retrive by id
		System.out.println("Retriev by id");
		System.out.println(Store.revieveById(id).toString());
		
		
		space(2);
		//delete
		System.out.println("delete event");
		System.out.println();
		System.out.println(Store.deleteEventById(id)?"successfully deleted":"not deleted successfully");
	
		
		//retrieve by month
		System.out.println("retrieve by month");
		Store.getEventByMonth(12).stream().forEach(System.out::println);
		space(2);
		//retrieve by year
		System.out.println("retrieve by year");
		Store.getEventByYear(1996).forEach(System.out::println);
		space(2);
		//retrieve by date
		System.out.println("retrieve by date");
		Store.getEventByDay(8).forEach(System.out::println);
		space(2);
	  //retrieve by month and eventtyps
		System.out.println("retrieve by month and eventtype");
		Store.getEventsByMonthAndEventType(12, EventType.BRITHDAY).forEach(System.out::println);

		
		
		
		
	}

	

	private static void space(int i) {
		while (i > 0) {
			System.out.println();
			i--;
		}
	}

}
