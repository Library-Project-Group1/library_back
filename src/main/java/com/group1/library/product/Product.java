package com.group1.library.product;

import com.group1.library.transaction.Transaction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

// Class characterizing the products, transformed into an entity managed by JPA

/**
 * <code>Class Product</code>
 * Class that characterizes a product present in our library
 */
@Entity
@Table(name = "products")
public class Product implements Serializable {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String creator;
    private Date releaseDate;
    private String description;
    private Long quantityTotal;
    private Long quantityAvailableToRent;
    private Long quantityIsRenting;
    private float price;
    private String pictureName;

    @ManyToOne
    @JoinColumn(name = "theme_fk")
    private Theme theme;

    @ManyToOne
    @JoinColumn(name = "category_fk")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<Transaction> transactions;

    // Empty Constructor
    public Product() {
    }

    // Constructor with all attributes
    public Product(Long id, String title, String creator, Date releaseDate, String description, Long quantityTotal, Long quantityAvailableToRent, Long quantityIsRenting, float price, String pictureName, Theme theme, Category category) {
        this.id = id;
        this.title = title;
        this.creator = creator;
        this.releaseDate = releaseDate;
        this.description = description;
        this.quantityTotal = quantityTotal;
        this.quantityAvailableToRent = quantityAvailableToRent;
        this.quantityIsRenting = quantityIsRenting;
        this.price = price;
        this.pictureName = pictureName;
        this.theme = theme;
        this.category = category;
    }

    // Constructor without id attribute
    public Product(String title, String creator, Date releaseDate, String description, Long quantityTotal, Long quantityAvailableToRent, Long quantityIsRenting, float price, String pictureName, Theme theme, Category category) {
        this.title = title;
        this.creator = creator;
        this.releaseDate = releaseDate;
        this.description = description;
        this.quantityTotal = quantityTotal;
        this.quantityAvailableToRent = quantityAvailableToRent;
        this.quantityIsRenting = quantityIsRenting;
        this.price = price;
        this.pictureName = pictureName;
        this.theme = theme;
        this.category = category;
    }

    public String toString() {
        return (this.id + "°) " + this.title);
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

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
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
