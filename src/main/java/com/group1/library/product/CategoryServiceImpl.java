package com.group1.library.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements AttributeProductService<Category,Long> {

    //ATTRIBUTES
    @Autowired
    private CategoryRepository catRepo;

    //METHODS

    //Method to add a new category in our database
    @Override
    public Category add(Category category) throws CategoryAlreadyExistsException {
        Category newCat=this.catRepo.getCategoryByName(category.getName());
        if (newCat==null) {
            this.catRepo.save(category);
        }else{
            throw new CategoryAlreadyExistsException();
        }
        return category;
    }

    //Method to find a category by id in our database
    @Override
    public Category getById(Long id) {
        Optional<Category> optionalCatToFind=this.catRepo.findById(id);
        Category catToFind = optionalCatToFind.get();
        return catToFind;
    }

    //Method to update the name of a category using his id in our database
    @Override
    public void edit(Category category, String name) {
        Long idToFind=category.getId();
        Optional<Category> catToEdit = this.catRepo.findById(idToFind);
        catToEdit.get().setName(name);
        this.catRepo.save(catToEdit.get());
    }

    //Method to remove a category using his name in our database
    @Override
    public void remove(Category category) {
        Category catToRemove= this.catRepo.getCategoryByName(category.getName());
        catRepo.delete(catToRemove);
    }

    //Method to get the categories list in our database
    @Override
    public Iterable<Category> getAll() {
        return this.catRepo.findAll();
    }
}
