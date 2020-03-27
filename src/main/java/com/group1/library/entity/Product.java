package com.group1.library.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * The {@code Product} class characterizes one product.
 * This class is an entity (a Java Bean) managed by JPA.
 * The {@code Product} class contains a non-exhaustive list of attributes that describe the products available in the online library.
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

    // CONSTRUCTORS
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

    // METHODS
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
     * @param title the title element to be associated with this {@code Product}.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the detail creator's name of the product.
     *
     * @return the creator's name of this product or {@code null} if the creator's name is nonexistent or unknown.
     */
    public String getCreator() {
        return creator;
    }

    /**
     * Sets the creator's name element that will be returned by {@link #getCreator()} method.
     *
     * @param creator the creator's name element to be associated with this {@code Product}.
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * Returns the detail released date of the product.
     *
     * @return the released date of this product or {@code null} if the released date is nonexistent or unknown.
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * Sets the released date element that will be returned by {@link #getReleaseDate()} method.
     *
     * @param releaseDate the released date element to be associated with this {@code Product}.
     */
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * Returns the detail description of the product.
     *
     * @return the description of this product or {@code null} if the description is nonexistent or unknown.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description element that will be returned by {@link #getDescription()} method.
     *
     * @param description the description element to be associated with this {@code Product}.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the detail total quantity of the product.
     *
     * @return the total quantity of this product or {@code null} if the total quantity is nonexistent or unknown.
     */
    public Long getQuantityTotal() {
        return quantityTotal;
    }

    /**
     * Sets the total quantity element that will be returned by {@link #getQuantityTotal()} method.
     *
     * @param quantityTotal the total quantity element to be associated with this {@code Product}.
     */
    public void setQuantityTotal(Long quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    /**
     * Returns the detail available quantity to rent of the product.
     *
     * @return the available quantity to rent of this product or {@code null} if the available quantity to rent is nonexistent or unknown.
     */
    public Long getQuantityAvailableToRent() {
        return quantityAvailableToRent;
    }

    /**
     * Sets the available quantity to rent element that will be returned by {@link #getQuantityAvailableToRent()} method.
     *
     * @param quantityAvailableToRent the available quantity to rent element to be associated with this {@code Product}.
     */
    public void setQuantityAvailableToRent(Long quantityAvailableToRent) {
        this.quantityAvailableToRent = quantityAvailableToRent;
    }

    /**
     * Returns the detail quantity already rented of the product.
     *
     * @return the quantity already rented of this product or {@code null} if the quantity already rented is nonexistent or unknown.
     */
    public Long getQuantityIsRenting() {
        return quantityIsRenting;
    }

    /**
     * Sets the quantity already rented element that will be returned by {@link #getQuantityIsRenting()} method.
     *
     * @param quantityIsRenting the quantity already rented element to be associated with this {@code Product}.
     */
    public void setQuantityIsRenting(Long quantityIsRenting) {
        this.quantityIsRenting = quantityIsRenting;
    }

    /**
     * Returns the detail price of the product.
     *
     * @return the price of this product or {@code null} if the price is nonexistent or unknown.
     */
    public float getPrice() {
        return price;
    }

    /**
     * Sets the price element that will be returned by {@link #getPrice()} method.
     *
     * @param price the price element to be associated with this {@code Product}.
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Returns the detail picture's name of the product.
     *
     * @return the picture's name of this product or {@code null} if the picture's name is nonexistent or unknown.
     */
    public String getPictureName() {
        return pictureName;
    }

    /**
     * Sets the picture's name element that will be returned by {@link #getPictureName()} method.
     *
     * @param pictureName the picture's name element to be associated with this {@code Product}.
     */
    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    /**
     * Returns the detail theme of the product which is an instance of the class {@code Theme}.
     *
     * @return the theme of this product or {@code null} if the theme is nonexistent or unknown.
     */
    public Theme getTheme() {
        return theme;
    }

    /**
     * Sets the theme element that will be returned by {@link #getTheme()} method.
     *
     * @param theme the {@code theme} element to be associated with this {@code Product}.
     */
    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    /**
     * Returns the detail category of the product which is an instance of the class {@code Category}.
     *
     * @return the category of this product or {@code null} if the category is nonexistent or unknown.
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sets the category element that will be returned by {@link #getCategory()} method.
     * @param category the {@code category} element to be associated with this {@code Product}.
     */
    public void setCategory(Category category) {
        this.category = category;
    }
}
