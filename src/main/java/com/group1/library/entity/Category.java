package com.group1.library.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * The {@code Category} class characterizes categories of products.
 * This class is transformed into an entity (a Java Bean) managed by JPA.
 * The {@code Category} class contains a list of products as attribute, because one category can defines many products.
 * This class is also composed of constructors and getters / setters.
 */
@Entity
@Table(name = "categories")
public class Category implements Serializable {

    // ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    /**
     * Constructs a new {@code Category} with {@code null} as its details.
     */
    public Category() {
    }

    /**
     * Constructs a new {@code Category} with the specified detail name.
     *
     * @param name the name of the {@code category}.
     */
    public Category(String name) {
        this.name = name;
    }

    /**
     * Constructs a new {@code Category} with the specified detail id and name.
     *
     * @param id   the id of the {@code category}.
     * @param name the name of the {@code category}.
     */
    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Returns a short description of the {@code Category} instance.
     * The result is the concatenation of:
     * <ul>
     *     <li>the id of the {@code Category} instance</li>
     *     <li>the name of the {@code Category} instance</li>
     * </ul>
     *
     * @return a string representation of this instance.
     */
    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    // GETTERS & SETTERS

    /**
     * Returns the detail id of the {@code category}.
     *
     * @return the id of this {@code Category} instance (which may be {@code null}).
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id element that will be returned by {@link #getId()} method.
     *
     * @param id the id element to be associated with this {@code Category}.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the detail name of the {@code category}.
     *
     * @return the name element of this {@code Category} instance (which may be {@code null}).
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name element that will be returned by {@link #getName()} method.
     *
     * @param name the name element to be associated with this {@code Category}.
     */
    public void setName(String name) {
        this.name = name;
    }
}
