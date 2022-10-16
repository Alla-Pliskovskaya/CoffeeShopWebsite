package com.coffeeshop.coffeeshopwebsite.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Bakery")
public class Bakery {
    @Id
    @GeneratedValue
    private Long id;

    private String bakeryName;
    private double bakeryPrice;
    private double calories;

    public Bakery(String bakeryName, double bakeryPrice, double calories) {
        this.bakeryName = bakeryName;
        this.bakeryPrice = bakeryPrice;
        this.calories = calories;
    }

    public Bakery() {

    }

    public String getBakeryName() {
        return bakeryName;
    }

    public double getBakeryPrice() {
        return bakeryPrice;
    }

    public double getCalories() {
        return calories;
    }

    public Long getId() {
        return id;
    }
}
