package com.assignment.book.exception;

import com.assignment.book.common.Message;

public class BookNotFoundException extends Exception {	

	private static final long serialVersionUID = 1L;
	
	public BookNotFoundException(long bookId) {		
		super(Message.RESOURCE_NOT_FOUND + " with id " + bookId);
    }
	
}
