package com.group1.library.service.inter;

import com.group1.library.exception.alreadyexists.CategoryAlreadyExistsException;
import com.group1.library.exception.notfound.CategoryNotFoundException;
import com.group1.library.exception.alreadyexists.ThemeAlreadyExistsException;
import com.group1.library.exception.notfound.ThemeNotFoundException;

public interface AttributeProductService<T, Long>    {

    T add(T t) throws CategoryAlreadyExistsException, ThemeAlreadyExistsException;

    T getById(Long id) throws ThemeNotFoundException, CategoryNotFoundException;

    void editById(Long id, T t) throws ThemeNotFoundException, CategoryNotFoundException;

    void removeById(Long id);

    Iterable<T> getAll();

}
