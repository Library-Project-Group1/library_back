package com.group1.library.exception.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "This category was not found.")
public class CategoryNotFoundException extends Throwable {
}

