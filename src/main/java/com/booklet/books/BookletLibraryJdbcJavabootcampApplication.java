package com.booklet.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.booklet.books.model.Book;
import com.booklet.books.service.IBookService;

@SpringBootApplication
public class BookletLibraryJdbcJavabootcampApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookletLibraryJdbcJavabootcampApplication.class, args);

//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//
//		IBookService bookService = context.getBean(IBookService.class);
		
		
		// ----------------- CREATE -----------------------
		// addBook
//		Book bookTemp = new Book(2, "Autor libro", "El pais de las maravillas", 2022, true, "Amazonas");
//		System.out.println(bookService.addBook(bookTemp).getMessage());;
		
		// ----------------- READ -----------------------
		//FindAllBooks
//		printBooks(bookService);
		
		//FindByAuthorName
//		System.out.println(bookService.findByAuthorName("Autor libro").getBooks());
		
		//FindByTitle
//		System.out.println(bookService.findByTitle("Game of thrones").getBooks());
		
		//FindByAuthorNameAndTitle
//		System.out.println(bookService.findByAuthorNameAndTitle("Autor libro", "El pais de las maravillas").getBooks());
		
		// ----------------- UPDATE -----------------------
		
		//UpdateBook
//		Book bookTempToUpdate = new Book(1, "George R.R Martin", "Game of thrones", 2022, true, "Bantam Books");
//		System.out.println(bookService.updateBook(bookTempToUpdate).getMessage());;
		
		//changeSellable
//		System.out.println(bookService.changeSellable(1, false));

		// ----------------- DELETE -----------------------
		
		//deleteBook
//		System.out.println(bookService.deleteBook(1));
//		
//		context.close();

	}

//	private static void printBooks(IBookService bookServ) {
//		System.out.println("Lista de libros: ");
//		for (Book book : bookServ.findAllBooks().getBooks()) {
//			System.out.println(book + "\n");
//		}
//	}

}
