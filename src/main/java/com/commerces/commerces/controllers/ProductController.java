package com.commerces.commerces.controllers;

import com.commerces.commerces.models.Product;
import com.commerces.commerces.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // ✅ Anyone can view products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // ✅ Anyone can view products By Id
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    // ✅ Only authenticated users can add products
    @PreAuthorize("isAuthenticated()")
    @PostMapping
    public Product createOrUpdateProduct(@RequestBody Product product) {
        return productService.saveOrUpdateProduct(product);
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return productService.saveOrUpdateProduct(product);
    }

    // ✅ Only authenticated users can delete products
    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }
}
