package ProjectBookStore.Bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ProjectBookStore.Bookstore.domain.Book;
import ProjectBookStore.Bookstore.domain.BookStoreRepository;

import java.util.List;
import java.util.ArrayList;

@Controller
public class BookController {

	@Autowired
	private BookStoreRepository repository;

	@GetMapping("/booklist")
	public String bookList(Model model) {

		// Get books from the repository
		Iterable<Book> repositoryBooks = repository.findAll();

		// Create an array of books
		Book[] arrayBooks = { new Book("Rich Dad, Poor Dad", "Robert T. Kiyosaki", 1997, "978-0446677455", 10.99),
				new Book("The Intelligent Investor", "Benjamin Graham", 1949, "978-0062312686", 15.99),
				new Book("The Essays of Warren Buffett", "Warren Buffett", 1997, "978-0966446128", 12.99),
				new Book("Think and Grow Rich", "Napoleon Hill", 1937, "978-1604591873", 8.99),
				new Book("The Snowball", "Alice Schroeder", 2008,
						"978-0553805093", 17.99),
				new Book("The Only Investment Guide You'll Ever Need", "Andrew Tobias", 1978, "978-0544781931", 11.99),
				new Book("The Little Book of Common Sense Investing", "John C. Bogle", 2007, "978-0470102107", 9.99),
				new Book("The Book on Rental Property Investing", "Brandon Turner", 2015, "978-0990711797", 14.99),
				new Book("A Beginner's Guide to the Stock Market", "Matthew R. Kratter", 2019, "978-1793297669", 6.99),
				new Book("The Money Manual", "Tonya B. Rapley", 2018, "978-1633537494", 13.99) };

		// Convert repository books to a list
		List<Book> repositoryBookList = new ArrayList<>();
		repositoryBooks.forEach(repositoryBookList::add);

		// Convert array books to a list
		List<Book> arrayBookList = List.of(arrayBooks);

		// Combine books from both sources into a single list
		List<Book> allBooks = new ArrayList<>();
		allBooks.addAll(repositoryBookList);
		allBooks.addAll(arrayBookList);

		model.addAttribute("bookList", allBooks);

		return "booklist";
	}
}
