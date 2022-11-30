package com.coffeeshop.coffeeshopwebsite.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "coffee_drink")
public class CoffeeDrink implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "coffee_name", length = 100, unique = true, nullable = false)
    private String coffeeName;
    @Column(name = "coffee_price", length = 50, nullable = false)
    private String coffeePrice;
    @Column(name = "volume", length = 50, nullable = false)
    private String volume;

    public CoffeeDrink(String coffeeName, String coffeePrice, String volume) {
        this.coffeeName = coffeeName;
        this.coffeePrice = coffeePrice;
        this.volume = volume;
    }

    public CoffeeDrink() {

    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public String getCoffeePrice() {
        return coffeePrice;
    }

    public String getVolume() {
        return volume;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public void setCoffeePrice(String coffeePrice) {
        this.coffeePrice = coffeePrice;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }
}
