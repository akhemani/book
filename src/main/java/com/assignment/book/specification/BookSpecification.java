package com.assignment.book.specification;

import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import com.assignment.book.model.Book;

public class BookSpecification {
	public static Specification<Book> searchbookloyee(String searchText) {
		return (root, query, criteriaBuilder) -> {			
			String toSearchText = "%" + searchText + "%";
			return criteriaBuilder.and(criteriaBuilder.or(						
										criteriaBuilder.like(root.get("title"), toSearchText),
										criteriaBuilder.like(root.get("author"), toSearchText)
									  )
					);
		};
	}
	
	public static Specification<Book> filterbookloyee(Book book) {
		return (root, query, criteriaBuilder) -> {
			
			Predicate p1 = criteriaBuilder.and();
			Predicate p2 = criteriaBuilder.and();
			Predicate p3 = criteriaBuilder.and();
			Predicate p4 = criteriaBuilder.and();
			
			if (book.getTitle() != null) {
				p1 = criteriaBuilder.equal(root.get("title"), book.getTitle());
			}
			
			if (book.getAuthor() != null) {
				p2 = criteriaBuilder.equal(root.get("author"), book.getAuthor());
			}
			
			if (book.getPrice() > -1) {
				p1 = criteriaBuilder.equal(root.get("price"), book.getPrice());
			}
			
			if (book.getIsbn() != null) {
				p2 = criteriaBuilder.equal(root.get("isbn"), book.getIsbn());
			}
			
			return criteriaBuilder.and(p1, p2, p3, p4);
		};
	}
}

