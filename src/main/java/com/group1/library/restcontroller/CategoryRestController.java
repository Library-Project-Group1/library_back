package com.group1.library.restcontroller;

import com.group1.library.entity.Category;
import com.group1.library.exception.alreadyexists.CategoryAlreadyExistsException;
import com.group1.library.exception.notfound.CategoryNotFoundException;
import com.group1.library.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/apiCategories")
public class CategoryRestController {

    @Autowired
    private CategoryServiceImpl catServImpl;

    public CategoryRestController() {
    }

    @PostMapping(path = "/createCategory", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> createCategory(@RequestBody @Valid Category category) {
        try {
            this.catServImpl.add(category);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (CategoryAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping("/category/{id}")
    public Category findCategoryById(@PathVariable("id") Long id) throws CategoryNotFoundException {
        Category catToFind = this.catServImpl.getById(id);
        return catToFind;
    }

    @PutMapping(value = "category/{id}/editCategory", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateCatById(@PathVariable("id") Long id, @RequestBody @Valid Category newCategory) {
        try {
            this.catServImpl.editById(id, newCategory);
        } catch (CategoryNotFoundException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/allCategories")
    public Iterable<Category> findAllCategories() {
        Iterable<Category> itCat = this.catServImpl.getAll();
        return itCat;
    }

    @DeleteMapping("/deleteCategory/{id}")
    public void deleteCatById(@PathVariable("id") Long id) throws CategoryNotFoundException {
        Category catToRemove = this.catServImpl.getById(id);
        catServImpl.removeById(catToRemove.getId());
    }

//    !! The following code was made for a Controller, not a RestController !!

//    @RequestMapping(value = "/addCategory", method = RequestMethod.GET)
//    public String getFormToAdd(@ModelAttribute("category") Category category, Model model) {
//        Category catToAdd = new Category();
//        model.addAttribute("name", catToAdd.getName());
//        System.out.println("New form is on access !");
//        return "";
//    }
//
//    @PostMapping(value = "/addCategory")
//    public String submitPost(@ModelAttribute Category category, @RequestParam("name") String name) {
//        try {
//            if (name != null) {
//                catServImpl.add(category);
//            }
//        } catch (CategoryAlreadyExistsException e) {
//            e.printStackTrace();
//        }
//        return "redirect:/category?id=" + category.getId();
//    }
//
//    @RequestMapping(value = "/removeCategory", method = RequestMethod.GET)
//    public String getFormToRemove(@ModelAttribute("category") Category category, Model model) {
//        Category catToAdd = new Category();
//        model.addAttribute("name", catToAdd.getName());
//        System.out.println("New form is on access !");
//        return "";
//    }
//
//    @GetMapping(value = "/category")
//    public String findById(@RequestParam(name = "id") Long id, Model model) {
//        Category catToFind =  catServImpl.getById(id);
//        model.addAttribute("oneCategory", catToFind);
//        System.out.println("It works");
//        return "";
//    }
//
//    @GetMapping(value = "/allCategories")
//    public String showUsers(Model model) {
//        model.addAttribute("categories", catServImpl.getAll());
//        return "";
//    }
}
