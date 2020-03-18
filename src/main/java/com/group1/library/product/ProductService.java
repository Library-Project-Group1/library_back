package com.group1.library.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Class containing all methods about the products

/**
 * <code>Class ProductService</code>
 */
@Service
public class ProductService {

    // Attribute
    @Autowired
    private ProductRepository repository;

    /**
     * Method to add a new product in the database
     * if the product is null, the product is created
     *
     * @param product the product to add in the database
     * @return the product to add into the save method
     * @throws ProductAlreadyExistException if the product already exist in the database
     */
    public Product addProduct(Product product) throws ProductAlreadyExistException {
        Product productToAdd = this.repository.getProductById(product.getId());
        if (productToAdd == null) {
            return this.repository.save(product);
        } else {
            throw new ProductAlreadyExistException();
        }
    }

    /**
     * Method to edit the price of a product by id
     * if the product exist, the price of the product is modified and this new price is saved in database
     *
     * @param id    the id of the product to edit in the database
     * @param price the price of the product to edit
     * @throws ProductNotFoundException if the product cannot be found in the database
     */
    public void updateProductById(Long id, float price) throws ProductNotFoundException {
        Product productToUpdate = this.repository.getProductById(id);
        if (productToUpdate == null) {
            throw new ProductNotFoundException();
        } else {
            productToUpdate.setPrice(price);
            this.repository.save(productToUpdate);
        }
    }

    /**
     * Method to edit the stock of a product by id
     * if the product exist, the total quantity of the product is modified and this new quantity is saved in the database
     *
     * @param id       the id of the product to edit in the database
     * @param quantity the quantity of the product to edit
     * @throws ProductNotFoundException if the product cannot be found in the database
     */
    public void updateStockById(Long id, Long quantity) throws ProductNotFoundException {
        Product productToUpdate = this.repository.getProductById(id);
        if (productToUpdate == null) {
            throw new ProductNotFoundException();
        } else {
            productToUpdate.setQuantityTotal(quantity);
            this.repository.save(productToUpdate);
        }
    }

    /**
     * Method to delete a product by id in the database
     *
     * @param id the id of the product to delete in the database
     * @throws ProductNotFoundException if the product cannot be found in the database
     */
    public void removeProductById(Long id) throws ProductNotFoundException {
        Product productToDelete = this.repository.getProductById(id);
        if (productToDelete == null) {
            throw new ProductNotFoundException();
        } else {
            this.repository.deleteById(id);
        }
    }

    /**
     * Method to find a product with the id in database
     *
     * @param id the id of the product to get in the database
     * @return An instance of Product, which corresponds to the product to find in database
     * @throws ProductNotFoundException if the product cannot be found in the database
     */
    public Product findProductById(Long id) throws ProductNotFoundException {
        Product productToFind = this.repository.getProductById(id);
        if (productToFind == null) {
            throw new ProductNotFoundException();
        }
        return productToFind;
    }

    /**
     * Method that retrieves all products list in database
     *
     * @return The list of all the products
     */
    public Iterable<Product> getAllProducts() {
        return (Iterable<Product>) this.repository.findAll();
    }
}
