package com.group1.library.product;

public class ThemeAlreadyExistsException extends Throwable {

    public ThemeAlreadyExistsException() {
        super("This theme already exists.");
    }
}
