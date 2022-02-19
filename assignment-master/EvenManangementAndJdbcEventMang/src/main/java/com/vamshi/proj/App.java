package com.vamshi.proj;

import java.time.LocalDate;
import java.util.List;

public class App {

	public static void main(String[] args){

		// save event
		System.out.println("save a event-------------------------------------");
		int isSaved = Dao.insertEvent(new Event(0, "vamshi", EventType.WEDDING_ANNIVERSARY, LocalDate.of(2000, 2, 15)));
		System.out.println(confirmation(isSaved) ? "The record is successfully saved" : "Not saved");

		space(2);
		// update the event
		System.out.println("update record-------------------------------------");
		int isUpdated = Dao.updateEvent(new Event(1, "vamshi", EventType.CONFERENCE, LocalDate.of(1996, 2, 3)));
		System.out.println(confirmation(isUpdated) ? "The record is updated successfully" : "Not Updated");
		space(2);
		// delete
		System.out.println("delete the record---------------------------------------------------------------");
		int isDelected = Dao.deleteEventById(12);
		System.out.println(confirmation(isDelected) ? "Deleted Successfully" : "NOt Deleted or record not existed");
		space(2);
		// retrieve events
		System.out.println("retriveing records-----------------------------------------------------------");
		System.out.println(Dao.revieveById(1));
		space(2);
		//
		// event in a year
		System.out.println("events in a particaler year------------------------------------------------");
		List<Event> list = Dao.getEventByYear("1996");
		list.stream().forEach(System.out::println);
		space(2);
		// event in the particular month
		System.out.println("Events in a particular Month-------------------------------------------");
		List<Event> listmonth = Dao.getEventByMonth("7");
		listmonth.forEach(System.out::println);
		space(3);
		// event in particlar day
		System.out.println("Events in a particular day-------------------------------------------");
		List<Event> listday = Dao.getEventByDay("7");
		listday.forEach(System.out::println);
		space(3);
		// event in particlar day
		System.out.println("Events in a particular month and eventtype-------------------------------------------");
		List<Event> listMonEvnType = Dao.getEventsByMonthAndEventType("12", EventType.BRITHDAY.toString());
		listMonEvnType.forEach(System.out::println);

	}

	private static boolean confirmation(int i) {
		return i == 1 ?true:false;
	}

	private static void space(int i) {
		while (i > 0) {
			System.out.println();
			i--;
		}
	}

}
