package com.coffeeshop.coffeeshopwebsite.models;

import javax.persistence.*;

@Entity
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "role_name", length = 50, nullable = false)
    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
