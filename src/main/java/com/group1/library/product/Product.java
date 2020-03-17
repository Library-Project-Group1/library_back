package com.group1.library.product;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

// Classe qui définit les produits
@Entity
@Table(name = "products")
public class Product implements Serializable {

    // ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String creator;
    private Long quantity;
    private Date releaseDate;
    private String description;

    @ManyToOne
    @JoinColumn(name = "theme_fk")
    private Theme theme;

    @ManyToOne
    @JoinColumn(name = "category_fk")
    private Category category;

    // CONSTRUCTOR
    public Product() {
    }

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

    public String getAuthor() {
        return creator;
    }

    public void setAuthor(String author) {
        this.creator = author;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
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
