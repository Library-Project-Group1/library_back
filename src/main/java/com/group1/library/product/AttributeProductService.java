package com.group1.library.product;

public interface AttributeProductService<T, Long>    {

    T add(T t) throws CategoryAlreadyExistsException, ThemeAlreadyExistsException;

    T getById(Long id) throws ThemeNotFoundException, CategoryNotFoundException;

    void editById(Long id, String name) throws ThemeNotFoundException;

    void removeById(Long id);

    Iterable<T> getAll();

}
