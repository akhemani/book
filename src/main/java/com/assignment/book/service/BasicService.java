package com.assignment.book.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface BasicService<T> {
	
	Page<T> findAll(Pageable pageable);

    Page<T> findAll(Specification<T> specification, Pageable pageable);

    List<T> findAll(Specification<T> specification);

    List<T> findAll();
	
	T save(T entity);

    T findById(Long id);

    Long deleteById(Long id);
}
