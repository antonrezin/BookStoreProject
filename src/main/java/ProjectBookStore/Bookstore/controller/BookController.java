package ProjectBookStore.Bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ProjectBookStore.Bookstore.domain.BookStoreRepository;

@Controller
public class BookController {
	@Autowired
	private BookStoreRepository repository;

	@RequestMapping("/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());

		return "booklist";
	}
	
}
