package com.coffeeshop.coffeeshopwebsite.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bakery")
public class Bakery implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "bakery_name", length = 100, unique = true, nullable = false)
    private String bakeryName;
    @Column(name = "bakery_price", nullable = false)
    private double bakeryPrice;
    @Column(name = "calories")
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setBakeryName(String bakeryName) {
        this.bakeryName = bakeryName;
    }

    public void setBakeryPrice(double bakeryPrice) {
        this.bakeryPrice = bakeryPrice;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }
}
