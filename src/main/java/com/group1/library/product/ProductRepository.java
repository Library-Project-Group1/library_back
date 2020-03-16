package com.group1.library.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    Product findProductById(Long id);

    Product saveProduct(Product product);

    void deleteProductById(Long id);

}
