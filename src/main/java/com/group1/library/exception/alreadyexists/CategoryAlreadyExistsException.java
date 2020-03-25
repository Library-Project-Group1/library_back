package com.group1.library.exception.alreadyexists;

public class CategoryAlreadyExistsException extends Exception {

    public CategoryAlreadyExistsException() {
        super("This category already exists in the database");
    }
}
