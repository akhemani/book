package com.assignment.book.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.assignment.book.model.Book;
import com.assignment.book.repository.BookRepository;
import com.assignment.book.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public Page<Book> findAll(Pageable pageable) {
		return bookRepository.findAll(pageable);
	}

	@Override
	public Page<Book> findAll(Specification<Book> specification, Pageable pageable) {
		return bookRepository.findAll(specification, pageable);
	}

	@Override
	public List<Book> findAll(Specification<Book> specification) {
		return bookRepository.findAll(specification);
	}

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public Book save(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book findById(Long id) {
		return bookRepository.findById(id).get();
	}

	@Override
	public Long deleteById(Long id) {
		bookRepository.deleteById(id);
		return id;
	}

}
