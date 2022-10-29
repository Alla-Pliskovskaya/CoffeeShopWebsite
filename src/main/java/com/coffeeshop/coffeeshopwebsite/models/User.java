package com.coffeeshop.coffeeshopwebsite.models;

import javax.persistence.*;

@Entity
@Table(name = "cafe_users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "login", length = 36, nullable = false, unique = true)
    private String login;
    @Column(name = "password", length = 128, nullable = false)
    private String password;
    @Column(name = "full_name")
    private String fullName;

    public User(String login, String password, String fullName) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
