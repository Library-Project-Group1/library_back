package com.group1.library.product;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
        super("This product was not found.");
    }
}
