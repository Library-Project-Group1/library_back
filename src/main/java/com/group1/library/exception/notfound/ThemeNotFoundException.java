package com.group1.library.exception.notfound;

public class ThemeNotFoundException extends Throwable {

    public ThemeNotFoundException() {
        super("This theme was not found.");
    }
}
