package com.commerces.commerces.controllers;

import com.commerces.commerces.models.Product;
import com.commerces.commerces.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Endpoint to get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Endpoint to get product by ID
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    // Endpoint to create or update a product
    @PostMapping
    public Product createOrUpdateProduct(@RequestBody Product product) {
        return productService.saveOrUpdateProduct(product);
    }

    // Endpoint to delete a product
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }
}
