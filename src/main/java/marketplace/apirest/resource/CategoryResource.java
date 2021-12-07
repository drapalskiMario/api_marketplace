package marketplace.apirest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import marketplace.apirest.entities.Category;
import marketplace.apirest.services.CategoryService;

@RestController
@RequestMapping(value = "/api/categories")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> findAll() {
        List<Category> categories = categoryService.findAll();
        return categories;
    }

    @GetMapping(value = "/{id}")
    public Category findById(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        return category;
    }
}
