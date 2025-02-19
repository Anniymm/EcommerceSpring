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

    // Update existing product
    public Product updateProduct(int id, Product updatedProduct) {
        Optional<Product> existingProduct = productRepository.findById((long) id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            return productRepository.save(product);
        } else {
            throw new RuntimeException("Product not found with ID: " + id);
        }
    }

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get product by ID
    public Product getProductById(int id) {
        return productRepository.findById((long) id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));
    }



    // Delete product
    public void deleteProduct(int id) {
        if (productRepository.existsById((long) id)) {
            productRepository.deleteById((long) id);
        } else {
            throw new RuntimeException("Product not found with ID: " + id);
        }
    }
}
