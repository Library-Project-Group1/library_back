package com.group1.library.restcontroller;

import com.group1.library.entity.Product;
import com.group1.library.exception.alreadyexists.ProductAlreadyExistException;
import com.group1.library.exception.notfound.ProductNotFoundException;
import com.group1.library.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <code>Class ProductRestController</code>
 * It returns all methods on products in JSON format
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/apiProducts")
public class ProductRestController {

    // Attribute
    @Autowired
    private ProductServiceImpl productService;

    /**
     * Method to create a new product
     *
     * @param product the product to add in the stock
     * @return An instance of ResponseEntity
     */
    @PostMapping(value = "/createProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createProduct(@RequestBody @Valid Product product) {
        try {
            this.productService.addProduct(product);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (ProductAlreadyExistException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    /**
     * Method to edit the price of a product by id
     *
     * @param id    the id of the product to edit
     * @param newproduct the product with the parameters to edit
     */
    @PutMapping(value = "/product/{id}/editProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateProductById(@PathVariable("id") Long id, @RequestBody @Valid Product newproduct) {
        try {
            this.productService.updateProductById(id, newproduct);
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * Method to delete a product by id
     *
     * @param id the id of the product to delete in the stock
     */
    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProductById(@PathVariable("id") Long id) {
        try {
            this.productService.removeProductById(id);
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to find a product by id
     *
     * @param id the id of the product to get in the stock
     * @return An instance of Product, which corresponds to the product to find
     * @throws ProductNotFoundException if the product cannot be found
     */
    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        Product productToFind = this.productService.findProductById(id);
        return productToFind;
    }

    /**
     * Method to get all products
     *
     * @return A list of all the products
     */
    @GetMapping("/allProducts")
    public Iterable<Product> findAllProducts() {
        return this.productService.findAllProducts();
    }
}
