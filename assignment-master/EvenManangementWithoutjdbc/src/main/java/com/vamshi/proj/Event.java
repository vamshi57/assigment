package com.vamshi.proj;

import java.time.LocalDate;

public class Event {
	private int id;
	private String personName;
	private EventType eventType;
	private LocalDate date;

	public Event() {
		super();
	}

	public Event(int id, String personName, EventType eventType, LocalDate date) {
	
		this.id = id;
		this.personName = personName;
		this.eventType = eventType;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", personName=" + personName + ", eventType=" + eventType + ", date=" + date + "]";
	}

}
