package com.vamshi.proj;

public class Book {
	
	private int id;
	private String name;
	private String type;
	private String author;
	private String publisher;
	
	
	public Book() {
		super();
	}


	public Book(int id, String name, String type, String author, String publisher) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.author = author;
		this.publisher = publisher;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", type=" + type + ", author=" + author + ", publisher="
				+ publisher + "]";
	}
	

	
     

}
