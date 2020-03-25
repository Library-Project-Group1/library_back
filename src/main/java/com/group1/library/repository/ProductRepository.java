package com.group1.library.repository;

import com.group1.library.entity.Category;
import com.group1.library.entity.Product;
import com.group1.library.entity.Theme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    Product getProductById(Long id);

    Product getProductByTitle(String title);

    Product getProductByCreator(String creator);

    Product getProductByCategory(Category category);

    Product getProductByTheme(Theme theme);

    Product getProductByPrice(Float price);

    Product getProductByReleaseDate(Date date);

}
