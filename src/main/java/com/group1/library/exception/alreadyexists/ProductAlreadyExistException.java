package com.group1.library.exception.alreadyexists;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "This product already exists in the database.")
public class ProductAlreadyExistException extends Throwable {
}
