package com.booklet.books.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booklet.books.dao.IBookDAO;
import com.booklet.books.model.Book;
import com.booklet.books.vo.BookVO;

@Service("bookService")
public class BookServiceImpl implements IBookService {
	
	@Autowired
	IBookDAO dao;
	BookVO response;
	Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

	@Override
	public BookVO addBook(Book book) {
		response = new BookVO(new ArrayList<Book>(), "Ocurred an error", "104");
		
		try {
			int addBookStatus = dao.addBook(book);
			response.setMessage(addBookStatus == 1 ? "Book added successfully" : "An error occurred and the book could not be added");
			response.setCode(addBookStatus == 1 ? "200" : "400");
		} catch (Exception e) {
			log.trace("Ocurred an error in addBook from BookServiceImpl", e);
		}
		return response;
	}

	@Override
	public BookVO findById(int book_id) {
		response = new BookVO(new ArrayList<Book>(), "Ocurred an error", "104");
		try {
			response.getBooks().add(dao.findById(book_id));
			response.setMessage("Book found");
			response.setCode("200");
		} catch (Exception e) {
			log.trace("Ocurred an error in findById from BookServiceImpl", e);
		}
		return response;
	}

	@Override
	public BookVO findAllBooks() {
		response = new BookVO(new ArrayList<Book>(), "Ocurred an error", "104");
		try {
			response.setBooks(new ArrayList<>(dao.findAllBooks()));
			response.setMessage(String.format("%d book registers found", response.getBooks().size()));
			response.setCode("200");
		} catch (Exception e) {
			log.trace("Ocurred an error in findAllBooks from BookServiceImpl", e);
		}
		return response;
	}

	@Override
	public BookVO findByAuthorName(String authorName) {
		response = new BookVO(new ArrayList<Book>(), "Ocurred an error", "104");
		try {
			response.getBooks().add(dao.findByAuthorName(authorName));
			response.setMessage("Author register found");
			response.setCode("200");
		} catch (Exception e) {
			log.trace("Ocurred an error in findByAuthorName from BookServiceImpl", e);
		}
		return response;
	}

	@Override
	public BookVO findByTitle(String title) {
		response = new BookVO(new ArrayList<Book>(), "Ocurred an error", "104");
		try {
			response.getBooks().add(dao.findByTitle(title));
			response.setMessage("Title register found");
			response.setCode("200");
		} catch (Exception e) {
			log.trace("Ocurred an error in findByTitle from BookServiceImpl", e);
		}
		return response;
	}

	@Override
	public BookVO findByAuthorNameAndTitle(String authorName, String title) {
		response = new BookVO(new ArrayList<Book>(), "Ocurred an error", "104");
		try {
			response.getBooks().add(dao.findByAuthorNameAndTitle(authorName, title));
			response.setMessage("Book register found");
			response.setCode("200");
		} catch (Exception e) {
			log.trace("Ocurred an error in findByAuthorNameAndTitle from BookServiceImpl", e);
		}
		return response;
	}

	@Override
	public BookVO updateBook(Book book) {
		response = new BookVO(new ArrayList<Book>(), "Ocurred an error", "104");
		try {
			int bookUpdateStatus = dao.updateBook(book);
			response.setMessage(bookUpdateStatus == 1 ? "Has been updated successfully" : "An error occurred in the update");
			response.setCode(bookUpdateStatus == 1 ? "200" : "400");
		} catch (Exception e) {
			log.trace("Ocurred an error in updateBook from BookServiceImpl", e);
		}
		return response;
	}

	@Override
	public BookVO changeSellable(int book_id, boolean sellable) {
		response = new BookVO(new ArrayList<Book>(), "Ocurred an error", "104");
		try {
			int changeStatus = dao.changeSellable(book_id, sellable);
			response.setMessage(changeStatus == 1 ? "Has been updated successfully" : "An error occurred in the update");
			response.setCode(changeStatus == 1 ? "200" : "400");
		} catch (Exception e) {
			log.trace("Ocurred and error in changeSelleable from BookServiceImpl", e);
			response.setMessage(String.format("Errorcito %d", e));
		}
		return response;
	}

	@Override
	public BookVO deleteBook(int book_id) {
		response = new BookVO(new ArrayList<Book>(), "Ocurred an error", "104");
		try {
			int deleteStatus = dao.deleteBook(book_id);
			response.setMessage(deleteStatus == 1 ? "Has been deleted successfully" : "An error occurred in the delete");
			response.setCode(deleteStatus == 1 ? "200" : "400");
		} catch (Exception e) {
			log.trace("Ocurred and error in deleteBook from BookServiceImpl", e);
		}
		return response;
	}

}
