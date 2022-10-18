package com.coffeeshop.coffeeshopwebsite.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CoffeeDrink")
public class CoffeeDrink {
    @Id
    @GeneratedValue
    private Long id;
    private String coffeeName;
    private Double coffeePrice;
    private String volume;

    public CoffeeDrink(String coffeeName, double coffeePrice, String volume) {
        this.coffeeName = coffeeName;
        this.coffeePrice = coffeePrice;
        this.volume = volume;
    }

    public CoffeeDrink() {

    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public double getCoffeePrice() {
        return coffeePrice;
    }

    public String getVolume() {
        return volume;
    }

    public Long getId() {
        return id;
    }
}
