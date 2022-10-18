package com.coffeeshop.coffeeshopwebsite.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CoffeeAdditive")
public class CoffeeAdditive {
    @Id
    @GeneratedValue
    private Long id;
    private String additiveName;
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
}
