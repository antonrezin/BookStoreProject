package ProjectBookStore.Bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ProjectBookStore.Bookstore.Entity.BookStoreRepository;

@Controller
public class BookController {

	@Autowired
	private BookStoreRepository repository;

	public class Book {
		public String title;
		public String author;
		public int year;
		public String isbn;
		public double price;

		public Book(String title, String author, int year, String isbn, double price) {
			this.title = title;
			this.author = author;
			this.year = year;
			this.isbn = isbn;
			this.price = price;
		}

	}

	@GetMapping("/booklist")
	public String bookList(Model model) {

		Book book1 = new Book("Rich Dad, Poor Dad", "Robert T. Kiyosaki", 1997, "978-0446677455", 10.99);
		Book book2 = new Book("The Intelligent Investor", "Benjamin Graham", 1949, "978-0062312686", 15.99);
		Book book3 = new Book("The Essays of Warren Buffett", "Warren Buffett", 1997, "978-0966446128", 12.99);

		model.addAttribute("bookList", repository.findAll());

		model.addAttribute("book1", book1);
		model.addAttribute("book2", book2);
		model.addAttribute("book3", book3);

		return "booklist";
	}
}
