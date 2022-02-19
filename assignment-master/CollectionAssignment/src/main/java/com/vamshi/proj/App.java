package com.vamshi.proj;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {

	public static void main(String[] args) {

		List<Book> list = getBooks();

		// fetch by id
		line();
		System.out.println("fecting by book id");
		list.stream().filter(p -> p.getId() == 1).sorted(Comparator.comparing(Book::getId)).forEach(System.out::println);

		// fetch get book name
		line();
		System.out.println("fecting by book name");
		
		list.stream().filter(p -> p.getName().equals("java")).sorted(Comparator.comparing(Book::getName))
				.forEach(System.out::println);

		// fetch get author
		line();
		System.out.println("fetching by author name");
		list.stream().filter(p -> p.getAuthor().equals("vamshi")).sorted(Comparator.comparing(Book::getAuthor))
				.forEach(System.out::println);

		// fetch get publisher
		line();
		System.out.println("fetching by publisher name");
		list.stream().filter(p -> p.getPublisher().equals("vamshi")).sorted(Comparator.comparing(Book::getPublisher))
				.forEach(System.out::println);

	
	    List<Borrower> borrowers=getBorrowes(list);
	     int bookid=3;
	     int borrowerid=findBorroweId(bookid, borrowers);
	     
	     //get book id
	     line();
	     System.out.println("borrower details  of ="+bookid);
	     
      List<Borrower>  borrs=borrowers.stream().filter(p->p.getBorrowerId()==borrowerid)
    		  .collect(Collectors.toList());
        borrs.forEach(System.out::println);
       line();
       System.out.print("number of books hold by borrewer of id ="+borrowerid);
     
       
          
      
              for (Borrower borrower : borrs) {
				System.out.println("  is  ="+borrower.getBorroweredBooks().size());
			}
	    
	
	
	}
	
	
	
	
	

	private static List<Book> getBooks() {

		return List.of(new Book(1, "java", "education", "vamshi", "vamshi"),
				new Book(2, "python", "education", "ram", "shiva"),
				new Book(3, "java", "education", "vamshi", "ramesh"),
				new Book(4, "javascript", "education", "suresh", "shiva"),
				new Book(5, "interseller", "action", "maju", "vamshi"),
				new Book(6, "inseller", "drama", "maju", "vamshi"), new Book(7, "erseller", "melody", "sai", "vamshi"),
				new Book(8, "inteller", "action", "harish", "vamshi"),
				new Book(9, "inteeller", "love", "shiva", "vfhi"),
				new Book(10, "inteler", "roematic", "shiva", "vamhi"));

	}
	
	private static List<Borrower> getBorrowes(List<Book> books){
		
		
		  
		
		return List.of(
				new Borrower(1, "vamshi",
						List.of(books.get(1),books.get(2),books.get(3))),
				new Borrower(2, "ram",
						List.of(books.get(4),books.get(5),books.get(6))),
				new Borrower(3, "vamshi",
						List.of(books.get(7),books.get(8),books.get(9)))
				);
	}
	
	private static int findBorroweId(int bookid,List<Borrower> borrowers) {
		int borrowerid =0;
		
		for (Borrower borrower : borrowers) {
		       List<Book> books=borrower.getBorroweredBooks();
		       for ( Book book: books) {
				 if(book.getId()==bookid) {
					 borrowerid=borrower.getBorrowerId();
					 System.out.println("book id");
				 }
			  }
		       
			}
		
		
      return borrowerid;		
	}
	private static void line() {
		System.out.println();
		System.out.println("------------------------------------------------------------------");
	}
	
	
	
	
}
