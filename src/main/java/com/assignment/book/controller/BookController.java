package com.assignment.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.assignment.book.common.Message;
import com.assignment.book.common.Response;
import com.assignment.book.common.ResultCode;
import com.assignment.book.exception.BookNotFoundException;
import com.assignment.book.model.Book;
import com.assignment.book.service.BookService;
import com.assignment.book.specification.BookSpecification;

@RestController
@RequestMapping(value = "/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/getAllByPages")
	public ResponseEntity<Response> getAllBooksPagination(Pageable pageable) {
		return new ResponseEntity<>(new Response(ResultCode.SUCCESS, bookService.findAll(pageable), Message.SUCCESS), HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<Response> getAllBooksList() {
		return new ResponseEntity<>(new Response(ResultCode.SUCCESS, bookService.findAll(), Message.SUCCESS), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response> getBookById(@PathVariable Long id) throws Exception {
		try {
			return new ResponseEntity<>(new Response(ResultCode.SUCCESS, bookService.findById(id), Message.SUCCESS), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(new Response(ResultCode.SUCCESS, new BookNotFoundException(id), Message.SUCCESS), HttpStatus.OK);
		}
		
	}
	
	@PostMapping
	public ResponseEntity<Response> createBook(@RequestBody Book book) {
		return new ResponseEntity<>(new Response(ResultCode.SUCCESS, bookService.save(book), Message.CREATED), HttpStatus.OK); 
	}
	
	@PutMapping
	public ResponseEntity<Response> updateBook(@RequestBody Book book) {
		return new ResponseEntity<>(new Response(ResultCode.SUCCESS, bookService.save(book), Message.UPDATED), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Response> deleteBookById(@PathVariable Long id) {
		return new ResponseEntity<>(new Response(ResultCode.SUCCESS, bookService.deleteById(id), Message.DELETED), HttpStatus.OK);
	}
	
	@GetMapping("/filterBook")
	public ResponseEntity<Response> filterBooks(@RequestBody Book book) {
		return new ResponseEntity<>(new Response(ResultCode.SUCCESS, bookService.findAll(BookSpecification.filterBook(book)), Message.SUCCESS), HttpStatus.OK);
	}
	
	@GetMapping("/searchBy/{searchedText}")
	public ResponseEntity<Response> searchBook(@PathVariable String searchedText) {
		return new ResponseEntity<>(new Response(ResultCode.SUCCESS, bookService.findAll(BookSpecification.searchBook(searchedText)), Message.SUCCESS), HttpStatus.OK);
	}

}
