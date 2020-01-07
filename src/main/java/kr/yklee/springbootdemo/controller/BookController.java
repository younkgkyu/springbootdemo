package kr.yklee.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.yklee.springbootdemo.domain.BaseResponse;
import kr.yklee.springbootdemo.domain.Book;
import kr.yklee.springbootdemo.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping("/{bookId}")
	public ResponseEntity<BaseResponse<Book>> findById(@PathVariable Long bookId) {
		System.out.println("bookId : " + bookId);
		Book resultBook = bookService.findById(bookId).orElse(null);
		BaseResponse<Book> result = new BaseResponse<Book>(1, "success");
		result.setResult(resultBook);
		return ResponseEntity.ok(result);
	}

	@PostMapping("/add")
	public ResponseEntity<BaseResponse<Book>> insertBook(@RequestBody Book book) {
		System.out.println("books : " + book.getName());
		Book resultBook = bookService.save(book);
		BaseResponse<Book> result = new BaseResponse<Book>(1, "success");
		result.setResult(resultBook);
		return ResponseEntity.ok(result);
	}
}
