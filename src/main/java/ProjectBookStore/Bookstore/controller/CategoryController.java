package ProjectBookStore.Bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ProjectBookStore.Bookstore.domain.Category;
import ProjectBookStore.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository crepository;

    @GetMapping("/addcategory")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    @PostMapping("/savecategory")
    public String saveCategory(@ModelAttribute Category category, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addcategory";
        }
        crepository.save(category);
        return "redirect:/categorylist";
    }

    @GetMapping("/categorylist")
    public String categoryList(Model model) {
        model.addAttribute("categories", crepository.findAll());
        return "categorylist";
    }
}
