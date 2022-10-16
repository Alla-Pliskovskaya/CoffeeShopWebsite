package com.coffeeshop.coffeeshopwebsite.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Calendar;

@Entity
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    private String login, coffee, additive, bakery;
    private Calendar dateTime;

    public Order(String login, String coffee, String additive, String bakery, Calendar dateTime) {
        this.login = login;
        this.coffee = coffee;
        this.additive = additive;
        this.bakery = bakery;
        this.dateTime = dateTime;
    }

    public Order() {

    }


    public String getLogin() {
        return login;
    }

    public String getCoffee() {
        return coffee;
    }

    public String getAdditive() {
        return additive;
    }

    public String getBakery() {
        return bakery;
    }

    public Calendar getDateTime() {
        return dateTime;
    }
}
