package com.commerces.commerces.services;

import com.commerces.commerces.models.Basket;
import com.commerces.commerces.models.BasketItem;
import com.commerces.commerces.models.Product;
import com.commerces.commerces.models.User;
import com.commerces.commerces.repository.BasketRepository;
import com.commerces.commerces.repository.ProductRepository;
import com.commerces.commerces.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BasketService {
    @Autowired
    private BasketRepository basketRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    // ✅ Get or Create Basket for a User
    public Basket getOrCreateBasket(Long userId) {
        return basketRepository.findByUserId(userId)
                .orElseGet(() -> {
                    User user = userRepository.findById(userId)
                            .orElseThrow(() -> new RuntimeException("User not found"));
                    Basket basket = new Basket();
                    basket.setUser(user);
                    return basketRepository.save(basket);
                });
    }

    // ✅ Add Product to Basket
    public Basket addProductToBasket(Long userId, Long productId, int quantity) {
        Basket basket = getOrCreateBasket(userId);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        BasketItem item = new BasketItem();
        item.setBasket(basket);
        item.setProduct(product);
        item.setQuantity(quantity);
        item.setTotalPrice(product.getPrice() * quantity);

        basket.getBasketItems().add(item);
        return basketRepository.save(basket);
    }

    // ✅ Remove Product from Basket
    public Basket removeProductFromBasket(Long userId, Long productId) {
        Basket basket = getOrCreateBasket(userId);

        basket.getBasketItems().removeIf(item -> item.getProduct().getId() == productId.intValue());

        return basketRepository.save(basket);
    }


    // ✅ Clear Basket (After Placing Order)
    public void clearBasket(Long userId) {
        Basket basket = getOrCreateBasket(userId);
        basket.getBasketItems().clear();
        basketRepository.save(basket);
    }

    //✅ Get Basket Items
    public List<BasketItem> getBasketItems(Long userId) {
        return getOrCreateBasket(userId).getBasketItems();
    }
}
