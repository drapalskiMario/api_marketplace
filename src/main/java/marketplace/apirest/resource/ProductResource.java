package marketplace.apirest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import marketplace.apirest.entities.Product;
import marketplace.apirest.services.ProductService;

@RestController
@RequestMapping(value = "/api/products")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> findAll() {
        List<Product> products = this.productService.findAll();
        return products;
    }

    @GetMapping(value = "/{id}")
    public Product findById(@PathVariable Long id) {
        Product product = this.productService.findById(id);
        return product;
    }
}
