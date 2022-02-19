package com.vamshi.proj;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao {

	private static Connection con;
	private static final String INSERT = "insert into events(person_name,event_type,date) values(?,?,?)";
	private static final String UPDATE_BY_ID = "update events set person_name=?,event_type=?,date=? where id=?";
	private static final String DELETE_BY_ID = "delete from events where id=?";
	private static final String RETRIEVE_BY_ID = "select id,person_name,event_type,date from events where id=?";
 	private static final String RETRIEVE_BY_YEAR="select id,person_name,event_type,date from events where TO_CHAR(date, 'yyyy')=?::varchar";
 	private static final String RETRIEVE_BY_MONTH="select id,person_name,event_type,date from events where TO_CHAR(date, 'mm')= ?::varchar";
 	private static final String RETRIEVE_BY_DAY="select id,person_name,event_type,date from events where TO_CHAR(date, 'dd')= ?::varchar";
 	private static final String RETRIEVE_BY_MONTH_AND_EVENTYPE="select id,person_name,event_type,date from events where TO_CHAR(date, 'mm')= ?::varchar and event_type=?";

 	
 	private Dao() {
 		
 	}
 	
 	
	static {
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres1", "psql1", "psql1");
		}  catch (SQLException e) {
			e.printStackTrace();
		}

	}
	// save
	public static int insertEvent(Event event)  {
		int res=0;
		try(PreparedStatement ps = con.prepareStatement(INSERT)){
		ps.setString(1, event.getPersonName());
		ps.setString(2, event.getEventType().toString());
		ps.setDate(3, Date.valueOf(event.getDate()));
		  res= ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	  return res;
	}

	// update
	public static int updateEvent(Event event){
		int res=0;
		try(PreparedStatement ps = con.prepareStatement(UPDATE_BY_ID)){
		
		ps.setString(1, event.getPersonName());
		ps.setString(2, event.getEventType().toString());
		ps.setDate(3, Date.valueOf(event.getDate()));
		ps.setInt(4, event.getId());
		res= ps.executeUpdate();
		}catch (SQLException e) {
		  e.printStackTrace();
		}
		return res;
	}

	// delete
	public static int deleteEventById(int id){
		int res=0;
		
		try(PreparedStatement ps = con.prepareStatement(DELETE_BY_ID)){
		ps.setInt(1, id);
		res= ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
		
	}

	// retrieve by id
	public static Event revieveById(int id){
		Event event=null;
		try(PreparedStatement ps = con.prepareStatement(RETRIEVE_BY_ID)){
		  ps.setInt(1, id);
		  ResultSet rs = ps.executeQuery();
	      event= getEventsByRs(rs).get(0);
		}catch (SQLException e) {
		  e.printStackTrace();
		}
	  return event;
	}
	//retrieve by year
	
	public static List<Event> getEventByYear(String year){
		List<Event> list=null;
		try(PreparedStatement ps=con.prepareStatement(RETRIEVE_BY_YEAR)){
		ps.setString(1, year);
		ResultSet rs=ps.executeQuery();
		list= getEventsByRs(rs);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//retrieve by month
	public static List<Event> getEventByMonth(String month){
		List<Event> list=null;
		try(PreparedStatement ps=con.prepareStatement(RETRIEVE_BY_MONTH)){
		if(month.length()<2) {
			month=0+""+month;
		}
		ps.setString(1, month);
		ResultSet rs=ps.executeQuery();
		 list= getEventsByRs(rs);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//retrieve by date
	public static List<Event> getEventByDay(String day){
		List<Event> list=null;
		try(PreparedStatement ps=con.prepareStatement(RETRIEVE_BY_DAY)){
		if(day.length()<2) {
			day=0+""+day;
		}
		ps.setString(1, day);
		ResultSet rs=ps.executeQuery();
		list= getEventsByRs(rs);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//retrive by month and event
	public static List<Event> getEventsByMonthAndEventType(String month,String eventType ){
		List<Event> list=null;
		try(	PreparedStatement ps=con.prepareStatement(RETRIEVE_BY_MONTH_AND_EVENTYPE)){
	
		if(month.length()<2) {
			month=0+""+month;
		}
		ps.setString(1, month);
		ps.setString(2, eventType);	
		ResultSet st=ps.executeQuery();
	    list= getEventsByRs(st);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	private static List<Event> getEventsByRs(ResultSet rs)throws SQLException{
		 List<Event> listEvents=new ArrayList<>();
		
		while (rs.next()) {
			Event event=new Event();
			event.setId(rs.getInt(1));
			event.setPersonName(rs.getString(2));
			event.setDate(rs.getDate(4).toLocalDate());

			if (EventType.BRITHDAY.toString().equalsIgnoreCase(rs.getString(3))) {
				event.setEventType(EventType.BRITHDAY);
			}
			if (EventType.WEDDING_ANNIVERSARY.toString().equalsIgnoreCase(rs.getString(3))) {
				event.setEventType(EventType.WEDDING_ANNIVERSARY);
			}
			if (EventType.CONFERENCE.toString().equalsIgnoreCase(rs.getString(3))) {
				event.setEventType(EventType.CONFERENCE);
			}
			if (EventType.GET_TOGETHER.toString().equalsIgnoreCase(rs.getString(3))) {
				event.setEventType(EventType.GET_TOGETHER);
			}
			listEvents.add(event);
		}
		
		return listEvents;
	}

}
