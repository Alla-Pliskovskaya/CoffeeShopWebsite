package com.coffeeshop.coffeeshopwebsite.models;

import javax.persistence.*;

@Entity
@Table(name = "coffee_additive")
public class CoffeeAdditive {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "additive_name", length = 100, nullable = false)
    private String additiveName;
    @Column(name = "additive_price", nullable = false)
    private double additivePrice;

    public CoffeeAdditive(String additiveName, double additivePrice) {
        this.additiveName = additiveName;
        this.additivePrice = additivePrice;
    }

    public CoffeeAdditive() {

    }

    public String getAdditiveName() {
        return additiveName;
    }

    public double getAdditivePrice() {
        return additivePrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAdditiveName(String additiveName) {
        this.additiveName = additiveName;
    }

    public void setAdditivePrice(double additivePrice) {
        this.additivePrice = additivePrice;
    }
}
