package com.group1.library.product;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Product already exist.")
public class ProductAlreadyExistException extends Throwable {
}