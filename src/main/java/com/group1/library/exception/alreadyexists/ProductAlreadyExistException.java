package com.group1.library.exception.alreadyexists;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "This product already exist.")
public class ProductAlreadyExistException extends Throwable {
}
