package ProjectBookStore.Bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ProjectBookStore.Bookstore.domain.BookStoreRepository;

@Controller
public class BookController {
    @Autowired
    private BookStoreRepository repository;

    @RequestMapping(value = { "/", "/addbook" })
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "addbook";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId) {
        repository.deleteById(bookId);
        return "redirect:/addbook";
    }
}
