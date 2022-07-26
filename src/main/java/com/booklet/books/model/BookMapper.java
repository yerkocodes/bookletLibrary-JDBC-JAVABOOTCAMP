package com.booklet.books.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BookMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Book book = new Book();
		
		book.setBook_id(rs.getInt("book_id"));
		book.setAuthor(rs.getString("author"));
		book.setTitle(rs.getString("title"));
		book.setYear(rs.getInt("year"));
		book.setSellable(rs.getBoolean("sellable"));
		book.setPrinting(rs.getString("printing"));

		return book;
	}

}
