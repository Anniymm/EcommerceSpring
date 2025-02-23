package com.commerces.commerces.controllers;

import com.commerces.commerces.models.Basket;
import com.commerces.commerces.models.BasketItem;
import com.commerces.commerces.services.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/basket")
public class BasketController {

    @Autowired
    private BasketService basketService;

    // ✅ Get Basket Items
    @GetMapping("/{userId}")
    public ResponseEntity<List<BasketItem>> getBasketItems(@PathVariable Long userId) {
        return ResponseEntity.ok(basketService.getBasketItems(userId));
    }

    // ✅ Add Product to Basket
    @PostMapping("/{userId}/{productId}")
    public ResponseEntity<Basket> addProductToBasket(@PathVariable Long userId, @PathVariable Long productId, @RequestParam int quantity) {
        return ResponseEntity.ok(basketService.addProductToBasket(userId, productId, quantity));
    }

    // ✅ Remove Product from Basket
    @DeleteMapping("/{userId}/{productId}")
    public ResponseEntity<Basket> removeProductFromBasket(@PathVariable Long userId, @PathVariable Long productId) {
        return ResponseEntity.ok(basketService.removeProductFromBasket(userId, productId));
    }

    // ✅ Clear Basket
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> clearBasket(@PathVariable Long userId) {
        basketService.clearBasket(userId);
        return ResponseEntity.ok("Basket cleared successfully.");
    }
}
