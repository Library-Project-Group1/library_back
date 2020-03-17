package com.group1.library.product;

public class ProductAlreadyExistException extends RuntimeException {

    public ProductAlreadyExistException() {
        super("This product already exist in the list.");
    }

}
