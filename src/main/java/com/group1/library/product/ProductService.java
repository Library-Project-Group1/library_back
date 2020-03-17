package com.group1.library.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    // ATTRIBUTE
    @Autowired
    private ProductRepository repository;

    /**
     * Method to add a new product
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
     * Method to edit one product by id
     * @return An instance of Product, which corresponds to the edited product
     * @throws ProductNotFoundException if the product doesn't exist
     */
    public Product updateProductById(Product product) throws ProductNotFoundException {
        Product productToUpdate = this.repository.getProductById(product.getId());
        if (productToUpdate == null) {
            throw new ProductNotFoundException();
        }
        // TODO: edit one or more attributes of a product
        return productToUpdate;
    }

    /**
     * Method to delete one product by id
     *
     */
    public void removeProductById(Product product) throws ProductNotFoundException {
        Product productToDelete = this.repository.getProductById(product.getId());
        if (productToDelete == null) {
            throw new ProductNotFoundException();
        }
        this.repository.deleteById(product.getId());
    }

    /**
     * Method that retrieves the product list to display it
     *
     * @return The list of all the products
     */
    public List<Product> getAllProducts() {
        return (List<Product>) this.repository.findAll();
    }
}
