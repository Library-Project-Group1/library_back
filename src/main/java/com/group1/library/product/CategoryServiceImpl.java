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
    public Category getById(Long id) throws CategoryNotFoundException {
        Optional<Category> optionalCatToFind=this.catRepo.findById(id);
        if (optionalCatToFind.isPresent()) {
            Category catToFind = optionalCatToFind.get();
            return catToFind;
        } else {
            throw new CategoryNotFoundException(id);
        }
    }

    //Method to update the name of a category using his id in our database
    @Override
    public void edit(Category category, String newName) {
        Long idToFind = category.getId();
        Optional<Category> optionalCatToEdit = this.catRepo.findById(idToFind);
        Category catToEdit = optionalCatToEdit.get();
        catToEdit.setName(newName);
        this.catRepo.save(catToEdit);
    }

    //Method to remove a category using his name in our database
    @Override
    public void remove(Long id) {
        Optional<Category> catToRemove= this.catRepo.findById(id);
        catRepo.delete(catToRemove.get());
    }

    //Method to get the categories list in our database
    @Override
    public Iterable<Category> getAll() {
        return this.catRepo.findAll();
    }
}
