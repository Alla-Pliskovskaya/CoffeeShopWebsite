package com.coffeeshop.coffeeshopwebsite.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role() {

    }

    public Long getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }
}
