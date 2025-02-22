package com.commerces.commerces.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name="baskets")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; //anu kalata konkretul users ekutvnis
    // onetoone imistvis rom ert users erti kalata aqvs

    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL)
    //erti cali basketi sheicavs sxvadasva products amitom minda onetomany
    private List<BasketItem> basketItems;


    //no-argument (default) constructor
    // radgan relationebi maqvs avtomaturad ver igulismeba es amitom unda davuwero (magalitad Product-shi avtomaturad moiazreba)
    public Basket() {}
}
