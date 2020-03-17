package com.group1.library.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryRestController {

    @Autowired
    private CategoryServiceImpl catServImpl;

    public CategoryRestController() {
    }

    
}
