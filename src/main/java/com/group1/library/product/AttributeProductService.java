package com.group1.library.product;


public interface AttributeProductService<T,Long> {

        public T add(T t) throws CategoryAlreadyExistsException, ThemeAlreadyExistsException;

        public T getById(Long id) throws ThemeNotFoundException, CategoryNotFoundException;

        void editById(Long id, String name);

        void removeById(Long id);

        Iterable<T> getAll();
}
