package com.booklet.books.service;

import com.booklet.books.model.Book;
import com.booklet.books.vo.BookVO;

public interface IBookService {

	//CREATE
	public BookVO addBook(Book book);

	//READ
	public BookVO findById(int book_id);
	public BookVO findAllBooks();
	public BookVO findByAuthorName(String authorName);
	public BookVO findByTitle(String title);
	public BookVO findByAuthorNameAndTitle(String authorName, String title);
	
	//UPDATE
	public BookVO updateBook(Book book);
	public BookVO changeSellable(int book_id, boolean sellable);
	
	//DELETE
	public BookVO deleteBook(int book_id);

}
