package com.group1.library.service.impl;

import com.group1.library.entity.Product;
import com.group1.library.exception.alreadyexists.ProductAlreadyExistException;
import com.group1.library.exception.notfound.ProductNotFoundException;
import com.group1.library.repository.ProductRepository;
import com.group1.library.service.inter.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * <code>Class ProductServiceImpl</code>
 * It contains all methods on products
 */
@Service
public class ProductServiceImpl implements ProductService {

    // Attributes
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StorageServiceImpl storageService;

    /**
     * Method to add a new product in the database
     * if the product is <code>null</code>, the product is created
     *
     * @param product the product to add in the database
     * @return the product to add into the save method
     * @throws ProductAlreadyExistException if the product already exist in the database
     */
    @Override
    public Product addProduct(Product product) throws ProductAlreadyExistException {
        Product productToAdd = this.productRepository.getProductById(product.getId());
        if (productToAdd == null) {
            return this.productRepository.save(product);
        } else {
            throw new ProductAlreadyExistException();
        }
    }

    /**
     * Method to add a new product with a picture in the database
     * stock the picture for the product then add the product
     *
     * @param product the new product to add in the database
     * @param file    the file to associate to the new product
     * @return An instance of Product, the product to add into the save method
     * @throws ProductAlreadyExistException if the product already exist in the database
     */
    @Override
    public Product addProductAndFile(Product product, MultipartFile file) throws ProductAlreadyExistException {
        storageService.savePicture(file);
        product.setPictureName(file.getOriginalFilename());
        this.addProduct(product);
        return product;
    }

    /**
     * Method to edit the price of a product by id
     * if the product exist, the price of the product is modified and this new price is saved in database
     *
     * @param id    the id of the product to edit in the database
     * @param newProduct the product with the parameters to edit
     * @throws ProductNotFoundException if the product cannot be found in the database
     */
    @Override
    public void updateProductById(Long id, Product newProduct) throws ProductNotFoundException {
        Product productToUpdate = this.productRepository.getProductById(id);
        if (productToUpdate == null) {
            throw new ProductNotFoundException();
        } else {
            productToUpdate.setPrice(newProduct.getPrice());
            productToUpdate.setQuantityTotal(newProduct.getQuantityTotal());
            productToUpdate.setQuantityAvailableToRent(productToUpdate.getQuantityTotal()-productToUpdate.getQuantityIsRenting());
            this.productRepository.save(productToUpdate);
        }
    }

    /**
     * Method to delete a product by id in the database
     *
     * @param id the id of the product to delete in the database
     * @throws ProductNotFoundException if the product cannot be found in the database
     */
    @Override
    public void removeProductById(Long id) throws ProductNotFoundException {
        Product productToDelete = this.productRepository.getProductById(id);
        if (productToDelete == null) {
            throw new ProductNotFoundException();
        } else {
            this.productRepository.deleteById(id);
        }
    }

    /**
     * Method to find a product with the id in database
     *
     * @param id the id of the product to get in the database
     * @return An instance of Product, which corresponds to the product to find in database
     * @throws ProductNotFoundException if the product cannot be found in the database
     */
    @Override
    public Product findProductById(Long id) throws ProductNotFoundException {
        Product productToFind = this.productRepository.getProductById(id);
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
    @Override
    public Iterable<Product> findAllProducts() {
        return this.productRepository.findAll();
    }
}
