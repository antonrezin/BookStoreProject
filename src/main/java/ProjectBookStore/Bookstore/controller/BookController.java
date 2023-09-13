package ProjectBookStore.Bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	public class Book {
		public String title;
		public String author;
		public int year;
		public String isbn;
		public double price;
	}
	
}
