package com.group1.library.product;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

// Class characterizing the products, transformed into an entity managed by JPA
@Entity
@Table(name = "products")
public class Product implements Serializable {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String creator;
    private Long quantityTotal;
    private Long quantityAvailableToRent;
    private Long quantityIsRenting;
    private float price;
    private Date releaseDate;
    private String description;

    @ManyToOne
    @JoinColumn(name = "theme_fk")
    private Theme theme;

    @ManyToOne
    @JoinColumn(name = "category_fk")
    private Category category;

    // Empty Constructor
    public Product() {
    }

    public Product(String title,float price){
        this.title=title;
        this.price=price;
    }

    public String toString(){
        return (this.id+"°) "+this.title);
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Long getQuantityTotal() {
        return quantityTotal;
    }

    public void setQuantityTotal(Long quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    public Long getQuantityAvailableToRent() {
        return quantityAvailableToRent;
    }

    public void setQuantityAvailableToRent(Long quantityAvailableToRent) {
        this.quantityAvailableToRent = quantityAvailableToRent;
    }

    public Long getQuantityIsRenting() {
        return quantityIsRenting;
    }

    public void setQuantityIsRenting(Long quantityIsRenting) {
        this.quantityIsRenting = quantityIsRenting;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
