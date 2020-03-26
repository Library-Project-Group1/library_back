package com.group1.library.service.impl;

import com.group1.library.entity.Category;
import com.group1.library.exception.alreadyexists.CategoryAlreadyExistsException;
import com.group1.library.exception.notfound.CategoryNotFoundException;
import com.group1.library.exception.notfound.ThemeNotFoundException;
import com.group1.library.repository.CategoryRepository;
import com.group1.library.service.inter.AttributeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <code>Class CategoryServiceImpl</code> defines...
 */
@Service
public class CategoryServiceImpl implements AttributeProductService<Category, Long> {

    // Attribute
    @Autowired
    private CategoryRepository catRepo;

    //Method to add a new category in our database
    @Override
    public Category add(Category category) throws CategoryAlreadyExistsException {
        Category newCat = this.catRepo.getCategoryByName(category.getName());
        if (newCat == null) {
            return this.catRepo.save(category);
        } else {
            throw new CategoryAlreadyExistsException();
        }
    }

    //Method to find a category by id in our database
    @Override
    public Category getById(Long id) throws CategoryNotFoundException {
        Optional<Category> optionalCatToFind = this.catRepo.findById(id);
        if (optionalCatToFind.isPresent()) {
            Category catToFind = optionalCatToFind.get();
            return catToFind;
        } else {
            throw new CategoryNotFoundException(id);
        }
    }

    //Method to update the name of a category using his id in our database
    @Override
    public void editById(Long id, Category newCategory) throws CategoryNotFoundException {
        Optional<Category> catToUpdate = this.catRepo.findById(id);
        if (!catToUpdate.isPresent()) {
            throw new CategoryNotFoundException(id);
        } else {
            Category categoryToUpdate = catToUpdate.get();
            categoryToUpdate.setName(newCategory.getName());
            this.catRepo.save(categoryToUpdate);
        }
    }

    //Method to remove a category using an id in our database
    @Override
    public void removeById(Long id) {
        catRepo.deleteById(id);
    }

    //Method to get the categories list from our database
    @Override
    public Iterable<Category> getAll() {
        return this.catRepo.findAll();
    }
}
