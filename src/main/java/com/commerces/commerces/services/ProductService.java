package com.commerces.commerces.services;

import com.commerces.commerces.models.Product;
import com.commerces.commerces.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Create or Update product
    public Product saveOrUpdateProduct(Product product) {
        return productRepository.save(product);
    }

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get product by ID
    public Optional<Product> getProductById(int id) {
        return productRepository.findById((long) id);
    }

    // Delete product
    public void deleteProduct(int id) {
        productRepository.deleteById((long) id);
    }
}
