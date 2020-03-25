package com.group1.library.entity;

import com.group1.library.entity.Product;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.io.Serializable;
import java.util.List;

// Class characterizing themes of products, transformed into an entity managed by JPA
@Entity
@Table(name = "themes")
public class Theme implements Serializable {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "theme")
    private List<Product> products;

    // Empty Constructor
    public Theme() {
    }

    // Constructor
    public Theme(String name) {
        this.name = name;
    }

    // Constructor
    public Theme(Long id,String name) {
        this.name = name;
        this.id=id;
    }

    @Override
    public String toString() {
        return ("Theme :" + this.id + "°) " + this.name);

    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

