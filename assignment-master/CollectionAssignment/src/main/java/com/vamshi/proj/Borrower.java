package com.vamshi.proj;

import java.util.List;

public class Borrower {
	
	private int borrowerId;
	private String borrowerName;
	private List<Book> borroweredBooks;
	
	
	public Borrower() {
		super();
	}

	public Borrower(int borrowerId, String borrowerName, List<Book> borroweredBooks) {
		super();
		this.borrowerId = borrowerId;
		this.borrowerName = borrowerName;
		this.borroweredBooks = borroweredBooks;
	}
	
	public int getBorrowerId() {
		return borrowerId;
	}
	public void setBorrowerId(int borrowerId) {
		this.borrowerId = borrowerId;
	}
	public String getBorrowerName() {
		return borrowerName;
	}
	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}
	public List<Book> getBorroweredBooks() {
		return borroweredBooks;
	}
	public void setBorroweredBooks(List<Book> borroweredBooks) {
		this.borroweredBooks = borroweredBooks;
	}

	@Override
	public String toString() {
		return "Borrower [borrowerId=" + borrowerId + ", borrowerName=" + borrowerName + ", borroweredBooks="
				+ borroweredBooks + "]";
	}
	
	
	
	
	

}
