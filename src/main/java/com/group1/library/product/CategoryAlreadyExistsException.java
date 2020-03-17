package com.group1.library.product;

public class CategoryAlreadyExistsException extends Exception {

    public CategoryAlreadyExistsException() {
        super("This category already exists in the database");
    }
}
