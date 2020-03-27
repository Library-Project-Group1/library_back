package com.group1.library.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * The {@code User} class characterizes a library customer.
 * This class is transformed into an entity (a Java Bean) managed by JPA.
 * The User class contains many attributes that define one customer.
 * This class it also composed of constructors and getters / setters.
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    // ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;

    // CONSTRUCTORS
    /**
     * Constructs a new user with {@code null} as its details.
     */
    public User() {
    }

    /**
     * Constructs a new user with the specified detail email and password.
     *
     * @param email    the email of the customer.
     * @param password the password of the customer.
     */
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Constructs a new user with the specified detail id, email and password.
     *
     * @param id       the id of the customer.
     * @param email    the email of the customer.
     * @param password the password of the customer.
     */
    public User(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    // METHODS
    /**
     * Returns a short description of the {@code User} instance.
     * The result is the concatenation of:
     * <ul>
     *     <li>the id of the {@code User} instance</li>
     *     <li>the email of the {@code User} instance</li>
     * </ul>
     *
     * @return a string representation of this instance.
     */
    @Override
    public String toString() {
        return (this.id + "°) " + " USER : " + this.email);
    }

    // GETTERS & SETTERS
    /**
     * Returns the detail id of the user.
     *
     * @return the id of this {@code User} instance (which may be {@code null}).
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the id element that will be returned by {@link #getId()} method.
     *
     * @param id the id element to be associated with this {@code User}.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Returns the detail email of the user.
     *
     * @return the email of this {@code User} instance (which may be {@code null}).
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email element that will be returned by {@link #getEmail()} method.
     *
     * @param email the email element to be associated with this {@code User}.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the detail password of the user.
     *
     * @return the password of this {@code User} instance (which may be {@code null}).
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password element that will be returned by {@link #getPassword()} method.
     *
     * @param password the password element to be associated with this {@code User}.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
