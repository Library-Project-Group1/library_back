package com.group1.library.product;

import java.util.List;

public interface AttributeProductService<T,Long> {

        public T add(T t) throws CategoryAlreadyExistsException, ThemeAlreadyExistsException;

        public T getById(Long id) throws ThemeNotFoundException;

        void edit(T t, String name);

        void remove(Long id);

        Iterable<T> getAll();
}
