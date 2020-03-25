package com.group1.library.service.impl;

import com.group1.library.entity.Product;
import com.group1.library.entity.Theme;
import com.group1.library.exception.alreadyexists.ThemeAlreadyExistsException;
import com.group1.library.exception.notfound.ThemeNotFoundException;
import com.group1.library.repository.ThemeRepository;
import com.group1.library.service.inter.AttributeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ThemeServiceImpl implements AttributeProductService<Theme, Long> {

    //Attribute
    @Autowired
    private ThemeRepository themeRepository;

    //Methods
    @Override
    public Theme add(Theme theme) throws ThemeAlreadyExistsException {
        //Method to add a theme in database
        Theme themeToAdd = themeRepository.getThemeById(theme.getId());
        if (themeToAdd == null) {

            this.themeRepository.save(theme);
            return theme;
        } else {
            throw new ThemeAlreadyExistsException();
        }

    }

    @Override
    public Theme getById(Long id) throws ThemeNotFoundException {
        //Method to find a theme by id
        Optional<Theme> theme = this.themeRepository.findById(id);
        if (theme.isPresent()) {
            Theme themeToFind = theme.get();
            return themeToFind;
        } else {
            throw new ThemeNotFoundException();
        }
    }

    @Override
    public void editById(Long id, String newName) throws ThemeNotFoundException {
        //Method to change the theme name
        Optional<Theme> optionalTheme = this.themeRepository.findById(id);
        if(!optionalTheme.isPresent()){
            throw new ThemeNotFoundException();
        } else{
            Theme themeToEdit = optionalTheme.get();
            themeToEdit.setName(newName);
            this.themeRepository.save(themeToEdit);
        }

    }

    @Override
    public void removeById(Long id) {
        //Method to remove a theme by id
        themeRepository.deleteById(id);
    }

    @Override
    public Iterable<Theme> getAll() {
        //Method to get all themes
        Iterable<Theme> themes = themeRepository.findAll();
        return themes;
    }
}
