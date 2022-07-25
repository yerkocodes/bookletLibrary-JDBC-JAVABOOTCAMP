package com.booklet.books.dao;

import java.util.List;

import com.booklet.books.model.Book;

public interface IBookDAO {
	
	//CREATE
	public int addBook(Book book);

	//READ
	public List<Book> findAllBooks();
	public Book findByAuthorName(String authorName);
	public Book findByTitle(String title);
	public Book findByAuthorNameAndTitle(String authorName, String title);
	
	//UPDATE
	public int updateBook(Book book);
	public int changeSelleable(int book_id, boolean selleable);
	
	//DELETE
	public int deleteBook(int book_id);

}
