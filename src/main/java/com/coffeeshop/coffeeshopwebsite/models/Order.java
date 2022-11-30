package com.coffeeshop.coffeeshopwebsite.models;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;

@Entity
@Table(name = "cafe_order")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne()
    @JoinColumn(name="coffee", referencedColumnName = "coffee_name")
    private CoffeeDrink coffeeDrink;
    @ManyToOne()
    @JoinColumn(name="additive", referencedColumnName = "additive_name")
    private CoffeeAdditive coffeeAdditive;
    @ManyToOne()
    @JoinColumn(name="bakery", referencedColumnName = "bakery_name")
    private Bakery bakery;
    @ManyToOne()
    @JoinColumn(name="username", referencedColumnName = "username")
    private User user;
    @Column(name = "date_time", nullable = false)
    private String dateTime;

    @Column(name = "coffee_volume", length = 50)
    private String volume;

    public Order() {

    }

    public Authentication getCurrentUser() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public Order(CoffeeDrink coffeeDrink, String volume, CoffeeAdditive coffeeAdditive, Bakery bakery, String dateTime) {
        this.coffeeDrink = coffeeDrink;
        this.volume = volume;
        this.coffeeAdditive = coffeeAdditive;
        this.bakery = bakery;
        this.dateTime = dateTime;
        user = (User) getCurrentUser().getPrincipal();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CoffeeDrink getCoffeeDrink() {
        return coffeeDrink;
    }

    public void setCoffeeDrink(CoffeeDrink coffeeDrink) {
        this.coffeeDrink = coffeeDrink;
    }

    public CoffeeAdditive getCoffeeAdditive() {
        return coffeeAdditive;
    }

    public void setCoffeeAdditive(CoffeeAdditive coffeeAdditive) {
        this.coffeeAdditive = coffeeAdditive;
    }

    public Bakery getBakery() {
        return bakery;
    }

    public void setBakery(Bakery bakery) {
        this.bakery = bakery;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }
}