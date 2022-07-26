package com.booklet.books.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.booklet.books.model.Book;
import com.booklet.books.model.BookMapper;

@Repository
public class BookDAOImpl implements IBookDAO {
	
	JdbcTemplate jdbcTemplate;
	
	// EMPTY CONSTRUCTOR
	@Autowired
	public BookDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int addBook(Book book) {
		return jdbcTemplate.update("INSERT INTO books (author, title, year, sellable, printing) VALUES (?, ?, ?, ?, ?)", book.getAuthor(), book.getTitle(), book.getYear(), book.isSellable(), book.getPrinting());
	}

	@Override
	public List<Book> findAllBooks() {
		return jdbcTemplate.query("SELECT * FROM books", new BookMapper());
	}

	@SuppressWarnings("deprecation")
	@Override
	public Book findByAuthorName(String authorName) {
		return jdbcTemplate.queryForObject("SELECT * FROM books WHERE author = ?", new Object[] { authorName }, new BookMapper());
	}

	@SuppressWarnings("deprecation")
	@Override
	public Book findByTitle(String title) {
		return jdbcTemplate.queryForObject("SELECT * FROM books WHERE title = ?", new Object[] { title }, new BookMapper());
	}

	@SuppressWarnings("deprecation")
	@Override
	public Book findByAuthorNameAndTitle(String authorName, String title) {
		return jdbcTemplate.queryForObject("SELECT * FROM books WHERE author = ? AND title = ?", new Object[] {authorName, title}, new BookMapper());
	}

	@Override
	public int updateBook(Book book) {
		return jdbcTemplate.update("UPDATE books SET author = ?, title = ?, year = ?, sellable = ?, printing = ? WHERE book_id = ?", book.getAuthor(), book.getTitle(), book.getYear(), book.isSellable(), book.getPrinting(), book.getBook_id());
	}

	@Override
	public int changeSellable(int book_id, boolean sellable) {
		return jdbcTemplate.update("UPDATE books SET sellable = ? WHERE book_id = ?", sellable, book_id);
	}

	@Override
	public int deleteBook(int book_id) {
		return jdbcTemplate.update("DELETE FROM books WHERE book_id = ?", book_id);
	}

}
