package com.group1.library.product;

public class CategoryNotFoundException extends RuntimeException {

    CategoryNotFoundException(Long id) {
        super("Could not find category with id = " + id);
    }
}
