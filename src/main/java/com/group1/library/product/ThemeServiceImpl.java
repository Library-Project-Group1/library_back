package com.group1.library.product;

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
        if (themeRepository.getThemeByName(theme.getName()) == null) {
            this.themeRepository.save(theme);
        } else {
            throw new ThemeAlreadyExistsException();
        }
        return theme;
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
    public void editById(Long id, String newName) {
        //Method to change the theme name
        Optional<Theme> themeToFind = themeRepository.findById(id);
        themeToFind.get().setName(newName);
        themeRepository.save(themeToFind.get());
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
