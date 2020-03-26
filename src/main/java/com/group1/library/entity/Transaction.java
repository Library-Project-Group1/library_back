package com.group1.library.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The {@code Transaction} class characterizes the transactions carried out by customers, i.e. the rental of products.
 * This class is an entity managed by JPA.
 * The Transaction class contains many attributes that define one transaction.
 * This class is also composed of a constructor and getters / setters.
 */
@Entity
@Table(name = "Historic")
public class Transaction implements Serializable {

    // ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_fk")

    private User user;

    @ManyToOne
    @JoinColumn(name = "product_fk")
    private Product product;

    /**
     * Constructs a new transaction with {@code null} as its details.
     */
    public Transaction() {
    }

    /**
     * Returns a short description of the {@code Transaction} instance.
     * The result is the concatenation of:
     * <ul>
     *     <li>the id of the {@code Transaction} instance</li>
     *     <li>the email of an {@code User} instance</li>
     *     <li>the title of the {@code Product} instance rented by this customer</li>
     * </ul>
     *
     * @return a string representation of this product.
     */
    public String toString() {
        return (this.id + "°) User :" + this.user.getEmail() + " bought the product :" + this.product.getTitle());
    }


    //GETTERS & SETTERS

    /**
     * Returns the detail id of the transaction.
     *
     * @return the id of this {@code Transaction} instance (which may be {@code null}).
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the id element that will be returned by {@link #getId()} method.
     *
     * @param id the id element to be associated with this {@code Transaction}.
     */
    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
