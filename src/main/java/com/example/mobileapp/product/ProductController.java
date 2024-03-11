package com.example.mobileapp.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("product")
    public Product addNewProduct(@RequestBody Product product) throws ProductExceptions {
        return this.productService.createProduct(product);
    }

    @GetMapping("product")
    public List<Product> getAllProducts() throws ProductExceptions {
        return this.productService.getAllProducts();
    }

    @DeleteMapping("removeProduct/{productId}")
    public void removeProduct(@PathVariable Integer productId) throws ProductExceptions {
        this.productService.deleteProduct(productId);
    }

    @GetMapping("product/{productId}")
    public Optional<Product> searchProduct(@PathVariable Integer productId) throws ProductExceptions {
        return this.productService.searchProduct(productId);
    }
}
