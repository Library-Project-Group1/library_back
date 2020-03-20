package com.group1.library.product;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

// Class characterizing categories of products, transformed into an entity managed by JPA
@Entity
@Table(name = "categories")
public class Category implements Serializable {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    // Empty Constructor
    public Category() {
    }

    // Constructor
    public Category(String name) {
        this.name = name;
    }

    public Category(Long id, String name) {
        this.id=id;
        this.name=name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
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
