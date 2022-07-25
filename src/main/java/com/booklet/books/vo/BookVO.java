package com.booklet.books.vo;

import java.util.List;

import com.booklet.books.model.Book;

public class BookVO {
	
	List<Book> books;
	String message;
	String code;
	
	// EMPTY CONSTRUCTOR
	public BookVO() {
		super();
	}

	// CONSTRUCTOR WITH FIELDS
	public BookVO(List<Book> books, String message, String code) {
		super();
		this.books = books;
		this.message = message;
		this.code = code;
	}

	//GETTERS AND SETTERS
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "BookVO [books=" + books + ", message=" + message + ", code=" + code + "]";
	}

}
