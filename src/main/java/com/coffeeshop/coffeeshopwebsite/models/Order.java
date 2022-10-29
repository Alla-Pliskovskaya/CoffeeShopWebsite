package com.coffeeshop.coffeeshopwebsite.models;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "cafe_order")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "login", length = 36, nullable = false)
    private String login;
    @Column(name = "coffee", length = 100)
    private String coffee;
    @Column(name = "additive", length = 100)
    private String  additive;
    @Column(name = "bakery", length = 100)
    private String bakery;
    @Column(name = "date_time", nullable = false)
    private String dateTime;

    public Order(String login, String coffee, String additive, String bakery, String dateTime) {
        this.login = login;
        this.coffee = coffee;
        this.additive = additive;
        this.bakery = bakery;
        this.dateTime = dateTime;
    }

    public Order() {

    }

    public Long getId() {
        return id;
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

    public String getDateTime() {
        return dateTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setCoffee(String coffee) {
        this.coffee = coffee;
    }

    public void setAdditive(String additive) {
        this.additive = additive;
    }

    public void setBakery(String bakery) {
        this.bakery = bakery;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
