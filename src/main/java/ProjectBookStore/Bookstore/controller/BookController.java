package ProjectBookStore.Bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ProjectBookStore.Bookstore.domain.Book;
import ProjectBookStore.Bookstore.domain.BookStoreRepository;
import ProjectBookStore.Bookstore.domain.Category;
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
		model.addAttribute("categories",crepository.findAll());
		return "addbook";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute Book book) {
	    repository.save(book);
	    return "redirect:/booklist";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String save(@ModelAttribute Book book, @RequestParam("category") Long categoryId) {
	    Category category = crepository.findById(categoryId).orElse(null);
	    book.setCategory(category);
	    repository.save(book);
	    return "redirect:/booklist";
	}
	
	@RequestMapping(value = "/editbook/{id}")
    public String showEditBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", repository.findById(bookId));
        return "editbook";
    }
	
	@RequestMapping(value = "/categorylist")
	public String categoryList(Model model) {
	    model.addAttribute("categories", crepository.findAll());
	    return "categorylist";
	}

}
