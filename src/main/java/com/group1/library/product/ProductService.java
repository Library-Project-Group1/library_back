package com.group1.library.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Class containing all methods about the products
@Service
public class ProductService {

    // Attribute
    @Autowired
    private ProductRepository repository;

    /**
     * Method to add a new product in database
     * if the product is null, we save the product
     *
     * @throws ProductAlreadyExistException if the product already exist
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
     * Method to edit a product by id
     *
     * @return An instance of Product, which corresponds to the edited product
     * @throws ProductNotFoundException if the product doesn't exist
     */
    public void updateProductById(Long id) throws ProductNotFoundException {
        Product productToUpdate = this.repository.getProductById(id);
        if (productToUpdate == null) {
            throw new ProductNotFoundException();
        }
        // TODO: edit one or more attributes of a product (use .set and .save)
    }

    /**
     * Method to delete a product by id
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
     * Method to find a product with the id
     *
     * @return An instance of Product, which corresponds to the product to find in database
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
