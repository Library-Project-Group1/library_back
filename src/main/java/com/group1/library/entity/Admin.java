package com.group1.library.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * The {@code Admin} class characterizes a library administrator.
 * This class is transformed into an entity (a java bean) managed by JPA.
 * The {@code Admin} class contains many attributes that define one administrator.
 * This class it also composed of constructors and getters / setters.
 */
@Entity
public class Admin implements Serializable {

    // ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String email;
    String password;

    /**
     * Constructs a new admin with {@code null} as its details.
     */
    public Admin() {
    }

    /**
     * Constructs a new {@code Admin} with the specified detail username and password.
     *
     * @param username the username of the admin.
     * @param password the password of the admin.
     */
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Returns a short description of the {@code Admin} instance.
     * The result is the concatenation of:
     * <ul>
     *     <li>the id of the {@code Admin} instance</li>
     *     <li>the username of the {@code Admin} instance</li>
     * </ul>
     *
     * @return a string representation of this instance.
     */
    public String toString() {
        return (this.id + "°) " + this.username);
    }

    // GETTERS & SETTERS

    /**
     * Returns the detail id of the {@code Admin}.
     *
     * @return the id of this {@code Admin} instance (which may be {@code null}).
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id element that will be returned by {@link #getId()} method.
     *
     * @param id the id element to be associated with this {@code Admin}.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the detail user name of the {@code Admin}.
     *
     * @return the user name of this {@code Admin} instance (which may be {@code null}).
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the user name element that will be returned by {@link #getUsername()} method.
     *
     * @param username the user name element to be associated with this {@code Admin} as his pseudonym.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the detail email of the {@code Admin}.
     *
     * @return the email of this {@code Admin} instance (which may be {@code null}).
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email element that will be returned by {@link #getEmail()} method.
     *
     * @param email the email element which {@code Admin} will use to create his account and login himself.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the detail password of the {@code Admin}.
     *
     * @return the password of this {@code Admin} instance (which may be {@code null}).
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password element that will be returned by {@link #getPassword()} method.
     *
     * @param password the password element which {@code Admin} will use to create his account and login himself.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
