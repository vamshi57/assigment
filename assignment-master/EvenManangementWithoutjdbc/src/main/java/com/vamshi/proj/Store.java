package com.vamshi.proj;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Store {
  private static List<Event> events=null;
  
   private Store() {
	   
   }
      

         static {
			events=new ArrayList<>();
			events.add(new Event(new Random().nextInt(1000), "vamshi", EventType.BRITHDAY, LocalDate.of(1996, 12, 8)));
			events.add(new Event(new Random().nextInt(1000), "ram", EventType.CONFERENCE, LocalDate.of(2021, 7, 8)));
			events.add(new Event(new Random().nextInt(1000), "ravi", EventType.GET_TOGETHER, LocalDate.of(2020, 11, 18)));
			events.add(new Event(new Random().nextInt(1000), "mahesh", EventType.WEDDING_ANNIVERSARY, LocalDate.of(1996, 12, 8)));
			events.add(new Event(new Random().nextInt(1000), "suzith", EventType.BRITHDAY, LocalDate.of(1996, 12, 8)));
			events.add(  new Event(new Random().nextInt(1000), "latha", EventType.WEDDING_ANNIVERSARY, LocalDate.of(1996, 12, 8)));
			events.add( new Event(new Random().nextInt(1000), "meena", EventType.CONFERENCE, LocalDate.of(2020, 2, 8)));
			events.add(new Event(new Random().nextInt(1000), "kumar", EventType.CONFERENCE, LocalDate.of(2021, 11, 12)));
			events.add(new Event(new Random().nextInt(1000), "anusha", EventType.GET_TOGETHER, LocalDate.of(2020, 12, 8)));
			events.add(new Event(new Random().nextInt(1000), "ankush", EventType.CONFERENCE, LocalDate.of(2019, 1, 9)));
			
		}
     //get some ids
         
         public static int getId() {
             int id=0;
        	 List<Event> list=events.stream().filter(p->p.getPersonName().equals("vamshi")).collect(Collectors.toList());
        	 System.out.println(list);
               if(list.size()==1) {
            	   id=list.get(0).getId();
               }
             return id;
         }
         
         
	
	// save
	public static boolean insertEvent(Event event)  {
		event.setId(new Random().nextInt(1000));
		events.add(event);
		return true;
	}

	// update
	public static boolean updateEvent(Event event){
		boolean rs=false;
		 List<Event> list=events.stream().filter(p->p.getId()==event.getId()).collect(Collectors.toList());
		 if (list.size()==1) {
			Event ev1=list.get(0);
			ev1.setDate(event.getDate());
			ev1.setEventType(event.getEventType());
			ev1.setPersonName(event.getPersonName());
			rs=true;
		}
		return rs;
	}

	// delete
	public static boolean deleteEventById(int id){
		boolean rs=false;
		List<Event> list=events.stream().filter(p->p.getId()==id).collect(Collectors.toList());
		 if (list.size()==1) {
				events.remove(list.get(0));
				rs=true;
			}
		return rs;
	}

	// retrieve by id
	public static Event revieveById(int id)  {
		Event event=null;
		List<Event> list=events.stream().filter(p->p.getId()==id).collect(Collectors.toList());
		if (list.size()==1) {
			event=list.get(0);
		}
		return event;
	}
	// retrieve by year

	public static List<Event> getEventByYear(int year) {
		return events.stream().filter(p->p.getDate().getYear()==year).collect(Collectors.toList());
	}

	// retrieve by month
	public static List<Event> getEventByMonth(int month){
		return events.stream().filter(p->p.getDate().getMonthValue()==month).collect(Collectors.toList());
	}

	// retrieve by date
	public static List<Event> getEventByDay(int day) {
		return events.stream().filter(p->p.getDate().getDayOfMonth()==day).collect(Collectors.toList());
	}

	// retrive by month and event
	public static List<Event> getEventsByMonthAndEventType(int month,EventType eventType) {
	return events.stream().filter(p->p.getDate().getMonthValue()==month&&p.getEventType().equals(eventType)).collect(Collectors.toList());
	}
	
	

}
