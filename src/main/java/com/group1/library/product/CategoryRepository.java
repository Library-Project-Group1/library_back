package com.group1.library.product;

import org.springframework.data.repository.CrudRepository;


public interface CategoryRepository extends CrudRepository<Category, Long> {

        Category getCategoryByName(String name);
}
