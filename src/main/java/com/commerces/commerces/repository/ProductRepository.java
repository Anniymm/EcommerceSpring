package com.commerces.commerces.repository;


import com.commerces.commerces.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//The repository ensures that CRUD operations
// (Create, Read, Update, Delete) are automatically available

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // built-in CRUD method maqvs aq
}
