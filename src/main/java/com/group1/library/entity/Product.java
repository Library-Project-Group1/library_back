package com.group1.library.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * The {@code Product} class characterizes one product.
 * This class is an entity managed by JPA.
 * The Product class contains a non-exhaustive list of attributes that describe the products available in the online library.
 * This class is also composed of a constructor and getters / setters.
 */
@Entity
@Table(name = "products")
public class Product implements Serializable {

    // ATTRIBUTES
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

    /**
     * Constructs a new product with {@code null} as its details.
     */
    public Product() {
    }

    /**
     * Constructs a new product with all the attributes as its details.
     *
     * @param title                   the title of the product.
     * @param creator                 the creator's name of the product.
     * @param releaseDate             the publication date of the product.
     * @param description             the description of the product.
     * @param quantityTotal           the total quantity of the product.
     * @param quantityAvailableToRent the quantity available to rent of the product.
     * @param quantityIsRenting       the quantity rented of the product.
     * @param price                   the price of the product.
     * @param pictureName             the picture's name associated to the product.
     * @param theme                   the theme of the product.
     * @param category                the category of the product.
     */
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

    /**
     * Constructs a new product with the specified detail title, creator and price.
     *
     * @param title   the title of the product.
     * @param creator the creator's name of the product.
     * @param price   the price of the product.
     */
    public Product(String title, String creator, float price) {
        this.title = title;
        this.creator = creator;
        this.price = price;
    }

    /**
     * Returns a short description of the {@code Product} instance.
     * The result is the concatenation of:
     * <ul>
     *     <li>the id of the {@code Product} instance</li>
     *     <li>the title of the {@code Product} instance</li>
     * </ul>
     *
     * @return a string representation of this product.
     */
    public String toString() {
        return (this.id + "°) " + this.title);
    }

    // GETTERS & SETTERS

    /**
     * Returns the detail id of the product.
     *
     * @return the id of this {@code Product} instance (which may be {@code null}).
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id element that will be returned by {@link #getId()} method.
     *
     * @param id the id element to be associated with this {@code Product}.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the detail title of the product.
     *
     * @return the title of this product or {@code null} if the title is nonexistent or unknown.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title element that will be returned by {@link #getTitle()} method.
     *
     * @param title the id element to be associated with this {@code Product}.
     */
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
