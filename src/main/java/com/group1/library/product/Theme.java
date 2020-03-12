package com.group1.library.product;

import java.io.Serializable;

public class Theme implements Serializable {

    private Long id;
    private String name;

    public Theme() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

