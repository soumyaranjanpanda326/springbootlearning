package com.api.book.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entities.Book;
import com.api.book.services.BookService;


//@Controller
@RestController
public class BookControllers {
	
	@Autowired
	private BookService bookService;

//	@RequestMapping(value="/books",method = RequestMethod.GET)

//	@ResponseBody    //doesn't need for rest api
	
	@GetMapping("/books")
	public List<Book> getBooks() {
		
//		book.setId(1);
//		book.setAuthor("Soumya");  
//		book.setTitle("Java");
//		BookService bookService = new BookService();
//		List<Book> allBooks = bookService.getAllBooks();
//		return allBooks;
		
		return this.bookService.getAllBooks();
	}
	
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id) {
		return this.bookService.getBookById(id);
	}

}
