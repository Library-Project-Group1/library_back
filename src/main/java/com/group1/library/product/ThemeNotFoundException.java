package com.group1.library.product;

public class ThemeNotFoundException extends Throwable {

    public ThemeNotFoundException() {
        super("This theme was not found.");
    }
}
