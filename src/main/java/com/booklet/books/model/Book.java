package com.booklet.books.model;

import org.springframework.stereotype.Component;

@Component("book")
public class Book {

	private int book_id; 
	private String author;
	private String title;
	private int year;
	private boolean sellable;
	private String printing;

	// EMPTY CONSTRUCTOR
	public Book() {
		super();
	}

	// CONSTRUCTOR WITH FIELDS
	public Book(int book_id, String author, String title, int year, boolean sellable, String printing) {
		super();
		this.book_id = book_id;
		this.author = author;
		this.title = title;
		this.year = year;
		this.sellable = sellable;
		this.printing = printing;
	}

	// GETTERS AND SETTERS
	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean isSellable() {
		return sellable;
	}

	public void setSellable(boolean sellable) {
		this.sellable = sellable;
	}

	public String getPrinting() {
		return printing;
	}

	public void setPrinting(String printing) {
		this.printing = printing;
	}

	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", author=" + author + ", title=" + title + ", year=" + year + ", sellable="
				+ sellable + ", printing=" + printing + "]";
	}
	
}
