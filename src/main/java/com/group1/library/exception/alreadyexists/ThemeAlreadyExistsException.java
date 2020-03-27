package com.group1.library.exception.alreadyexists;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason ="This theme already exists." )
public class ThemeAlreadyExistsException extends Throwable {
    }
