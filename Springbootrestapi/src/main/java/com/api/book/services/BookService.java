package com.api.book.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.api.book.entities.Book;

//@Service
@Component
public class BookService {
	
	private static List<Book> list = new ArrayList<Book>();
	
	
	static {
		list.add(new Book(11,"Java","ABC"));
		list.add(new Book(21,"python","xyz"));
		list.add(new Book(14,"c","asd"));
		list.add(new Book(41,"c#","ghy"));
	}
	
	
	
//	 to get all boook
	public List<Book> getAllBooks(){
		return list;		
	}
	
	
//	 to get a particular book by ID
	
	public Book getBookById(int id) {
		
		
		return list.stream().filter(e->e.getId()==id).findFirst().get();
	}

}
