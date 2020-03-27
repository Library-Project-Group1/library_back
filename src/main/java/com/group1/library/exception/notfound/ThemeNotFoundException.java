package com.group1.library.exception.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason ="This theme was not found." )
public class ThemeNotFoundException extends Throwable {


}
