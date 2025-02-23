package com.commerces.commerces.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "basket_items")
public class BasketItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "basket_id", nullable = false)
    @JsonBackReference //json responshi infinite loops miketebda relationshipis gamo
    private Basket basket;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    //    Many BasketItem entries can be associated with one Product.
//    Each BasketItem must reference a single Product via the foreign key (product_id).
//    A single product can exist in multiple BasketItem records if different baskets contain the same product.
    private Product product;

    private int quantity;

    private double totalPrice;

    public BasketItem() {}

}
