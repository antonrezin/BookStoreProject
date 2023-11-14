package ProjectBookStore.Bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ProjectBookStore.Bookstore.domain.Book;
import ProjectBookStore.Bookstore.domain.BookStoreRepository;
import ProjectBookStore.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookStoreRepository repository;
	
	@Autowired
	private CategoryRepository crepository;

	@RequestMapping(value = { "/booklist" })
	public String bookList(Model model) {
		model.addAttribute("bookList", repository.findAll());
		return "booklist";
	}

	@RequestMapping(value = "/addbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categorys", crepository.findAll());
		return "addbook";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Book book) {
	    repository.save(book);
	    return "redirect:/booklist";
	}

	@GetMapping("/delete/{id}")
	    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
	    return "redirect:/booklist";
	}
	
	@RequestMapping(value = "/editbook/{id}")
    public String showEditBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", repository.findById(bookId));
        model.addAttribute("categorys", crepository.findAll());
        return "editbook";
    }

}
