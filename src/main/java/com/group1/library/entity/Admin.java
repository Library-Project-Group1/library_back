package com.group1.library.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * The {@code Admin} class characterizes a library administrator.
 * This class is transformed into an entity managed by JPA.
 * The Admin class contains many attributes that define one administrator.
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
     * Constructs a new admin with the specified detail username and password.
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
     * Returns the detail id of the admin.
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
