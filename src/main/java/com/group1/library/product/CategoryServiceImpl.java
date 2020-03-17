package com.group1.library.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements AttributeProductService<Category,Long> {

    //ATTRIBUTES
    @Autowired
    private CategoryRepository catRepo;

    @Override
    public Category add(Category category) {
        return null;
    }

    @Override
    public Category getById(Long id) {
        return null;
    }

    @Override
    public void edit(Category category) {

    }

    @Override
    public void remove(Category category) {

    }

    @Override
    public List getAll() {
        return null;
    }
}
