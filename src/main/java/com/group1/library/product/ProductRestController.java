package com.group1.library.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class ProductRestController {

    // Attribute
    @Autowired
    private ProductService productService;

    /**
     * Method to create a new product
     *
     * @param product
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
     * Method to edit a product by id
     *
     * @param id
     * @throws ProductNotFoundException
     */
    @PostMapping(value = "/product/{id}/editProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        this.productService.updateProductById(id);
        // TODO: complete this method
    }

    /**
     * Method to delete a product by id
     *
     * @param id
     */
    @GetMapping("/deleteProduct")
    public void deleteProductById(Long id) {
        try {
            this.productService.removeProductById(id);
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to find a product by id
     *
     * @param id
     * @return An instance of Product
     * @throws ProductNotFoundException
     */
    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        Product productToFind = this.productService.findProductById(id);
        return productToFind;
    }

    /**
     * Method to get all products
     *
     * @return
     */
    @GetMapping("/allProducts")
    public Iterable<Product> findAllProducts() {
        return this.productService.getAllProducts();
    }
}
