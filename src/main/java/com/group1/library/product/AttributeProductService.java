package com.group1.library.product;

import java.util.List;

public interface AttributeProductService<T,Long> {

        public T addProduct(T t);

        public T getById(Long id);

        void edit(T t);

        void remove(T t);

        List<T> getAll();
}
