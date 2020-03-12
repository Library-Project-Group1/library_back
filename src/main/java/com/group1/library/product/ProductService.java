package com.group1.library.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product addProduct(Product product) {
        return null;
    }

    public void updateProduct(Product product) {
    }

    public void removeProduct(Product product) {
    }
}
