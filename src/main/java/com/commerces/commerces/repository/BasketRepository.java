package com.commerces.commerces.repository;

import com.commerces.commerces.models.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BasketRepository extends JpaRepository<Basket, Long> {
    Optional<Basket> findByUserId(Long id);
}
