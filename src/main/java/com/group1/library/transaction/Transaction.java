package com.group1.library.transaction;

import com.group1.library.product.Product;
import com.group1.library.user.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Historic")
public class Transaction implements Serializable {
    //ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="user_fk")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_fk")
    private Product product;


    //CONSTRUCTOR
    public Transaction(){
    }

    //METHODS
    public String toString(){
        return (this.id+"°) User :"+this.user.getEmail()+" bought the product :"+this.product.getTitle());
    }


    //GETTER & SETTER
    public long getId() {
        return id;
    }

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
