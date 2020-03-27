package com.group1.library.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

/**
 * The {@code Theme} class characterizes themes of products.
 * This class is transformed into an entity (a Java Bean) managed by JPA.
 * The Theme class contains a list of products as attribute, because one theme can defines many products.
 * This class is also composed of constructors and getters / setters.
 */
@Entity
@Table(name = "themes")
public class Theme implements Serializable {

    // ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "theme")
    private List<Product> products;

    // CONSTRUCTORS
    /**
     * Constructs a new theme with {@code null} as its details.
     */
    public Theme() {
    }

    /**
     * Constructs a new theme with the specified detail name.
     *
     * @param name the name of the theme.
     */
    public Theme(String name) {
        this.name = name;
    }

    /**
     * Constructs a new theme with the specified detail id and name.
     *
     * @param id   the id of the theme.
     * @param name the name of the theme.
     */
    public Theme(Long id, String name) {
        this.name = name;
        this.id = id;
    }

    // METHODS
    /**
     * Returns a short description of the {@code Theme} instance.
     * The result is the concatenation of:
     * <ul>
     *     <li>the id of the {@code Theme} instance</li>
     *     <li>the name of the {@code Theme} instance</li>
     * </ul>
     *
     * @return a string representation of this theme.
     */
    @Override
    public String toString() {
        return ("Theme :" + this.id + "°) " + this.name);

    }

    // GETTERS & SETTERS
    /**
     * Returns the detail id of the theme.
     *
     * @return the id of this {@code Theme} instance (which may be {@code null}).
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id element that will be returned by {@link #getId()} method.
     *
     * @param id the id element to be associated with this {@code Theme}.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the detail name of the theme.
     *
     * @return the name of this {@code Theme} instance (which may be {@code null}).
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name element that will be returned by {@link #getName()} method.
     *
     * @param name the id element to be associated with this {@code Theme}.
     */
    public void setName(String name) {
        this.name = name;
    }
}

