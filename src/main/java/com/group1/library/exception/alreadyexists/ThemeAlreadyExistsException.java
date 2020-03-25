package com.group1.library.exception.alreadyexists;

public class ThemeAlreadyExistsException extends Throwable {

    public ThemeAlreadyExistsException() {
        super("This theme already exists.");
    }
}
