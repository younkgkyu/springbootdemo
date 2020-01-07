package kr.yklee.springbootdemo.service;

import java.util.List;
import java.util.Optional;

import kr.yklee.springbootdemo.domain.Book;

public interface BookService {

	Optional<Book> findById(Long id);
	List<Book> findAll();
	Book save(Book book);
	
}
