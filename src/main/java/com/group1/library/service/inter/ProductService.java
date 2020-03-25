package com.group1.library.service.inter;

import com.group1.library.entity.Product;
import com.group1.library.exception.alreadyexists.ProductAlreadyExistException;
import com.group1.library.exception.notfound.ProductNotFoundException;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {

    Product addProduct(Product product) throws ProductAlreadyExistException;

    Product addProductAndFile(Product product, MultipartFile file) throws ProductAlreadyExistException;

    void updateProductById(Long id, Product newProduct) throws ProductNotFoundException;
//    void updateProductById(Long id, float price) throws ProductNotFoundException;

//    void updateStockById(Long id, Long quantity) throws ProductNotFoundException;

    void removeProductById(Long id) throws ProductNotFoundException;

    Product findProductById(Long id) throws ProductNotFoundException;

    Iterable<Product> findAllProducts();
}
