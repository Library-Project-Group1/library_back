package com.group1.library.product;

public interface ProductService {

    Product addProduct(Product product) throws ProductAlreadyExistException;

    void updateProductById(Long id, float price) throws ProductNotFoundException;

    void updateStockById(Long id, Long quantity) throws ProductNotFoundException;

    void removeProductById(Long id) throws ProductNotFoundException;

    Product findProductById(Long id) throws ProductNotFoundException;

    Iterable<Product> findAllProducts();
}
