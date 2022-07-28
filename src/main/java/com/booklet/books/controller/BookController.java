package com.booklet.books.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.booklet.books.model.Book;
import com.booklet.books.service.BookServiceImpl;
import com.booklet.books.service.IBookService;

@Controller
@RequestMapping(value = "/bookManager", method = RequestMethod.GET)
public class BookController {
	
	@Autowired
	private IBookService bookService;
	
	private int idToUpdateBook = 0;

	public BookController() {
		super();
		bookService = new BookServiceImpl();
	}

	@RequestMapping(value = "/newBook", method = RequestMethod.GET)
	public String addBook() {
		return "addBookForm";
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String sendBook(ModelMap model, @ModelAttribute("bookForm") Book book) {
		System.out.println(bookService.addBook(book).getMessage());
		return "redirect:/bookManager/home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String findAllBooks(ModelMap model) {
		model.addAttribute("bookList", bookService.findAllBooks().getBooks());
		return "bookHome";
	}

	public String findByAuthorName(ModelMap model, @RequestParam("authorName") String authorName) {
		return null;
	}

	public String findByTitle(ModelMap model, @RequestParam("title") String title) {
		return null;
	}

	@RequestMapping(value = "/findBook", method = RequestMethod.POST)
	public String findByAuthorNameAndTitle(ModelMap model, @RequestParam("authorName") String authorName, @RequestParam("title") String title) {
		
		if (authorName != "" && title != "") {
			model.addAttribute("bookList", bookService.findByAuthorNameAndTitle(authorName, title).getBooks());
			model.addAttribute("statusMessage", bookService.findByAuthorNameAndTitle(authorName, title).getMessage());
		}

		if (authorName != "" && title == "") {
			model.addAttribute("bookList", bookService.findByAuthorName(authorName).getBooks());
			model.addAttribute("statusMessage", bookService.findByAuthorName(authorName).getMessage());
		}

		if (authorName == "" && title != "") {
			model.addAttribute("bookList", bookService.findByTitle(title).getBooks());
			model.addAttribute("statusMessage", bookService.findByTitle(title).getMessage());
		}

		if (authorName == "" && title == "") {
			model.addAttribute("bookList", new ArrayList<>());
			model.addAttribute("statusMessage", "You must fill at least one field in the search");
		}
		
		return "listFoundBooks";
	}

	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateBookGET(ModelMap model, @RequestParam("book_id") int book_id) {
		idToUpdateBook = book_id;
		model.addAttribute("bookToUpdate", bookService.findById(book_id).getBooks().get(0));
		return "updateBook";
	}

	@RequestMapping(value="/updateBook", method=RequestMethod.POST)
	public String updateBookPOST(ModelMap model, @ModelAttribute("updateBookForm") Book book) {
		book.setBook_id(idToUpdateBook);
		bookService.updateBook(book);
		return "redirect:/bookManager/home";
	}

	@RequestMapping(value="/changeSellable", method=RequestMethod.GET)
	public String changeSellable(ModelMap model, @RequestParam("book_id") int book_id, @RequestParam("sellable") boolean sellable) {
		bookService.changeSellable(book_id, sellable);
		return "redirect:/bookManager/home";
	}

	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteBook(ModelMap model, @RequestParam("book_id") int book_id) {
		bookService.deleteBook(book_id);
		return "redirect:/bookManager/home";
	}

}
