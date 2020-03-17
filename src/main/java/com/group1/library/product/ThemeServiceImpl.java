package com.group1.library.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeServiceImpl implements AttributeProductService<Theme,Long> {

    //Attributes
    @Autowired
    private ThemeRepository themeRepository;

    //Methods
    @Override
    public Theme add(Theme theme) throws ThemeAlreadyExistsException {
        //Method to add a theme in database
        if(themeRepository.getThemeByThemeName(theme.getName())==null){
            this.themeRepository.save(theme);
        }else{
            throw new ThemeAlreadyExistsException();
        }

        return theme;
    }

    @Override
    public Theme getById(Long id) {
        //Method to find a theme by id
        Optional<Theme>theme = this.themeRepository.findById(id);
        Theme themeToFind = theme.get();
        return themeToFind;
    }

    @Override
    public void edit(Theme theme, String name) {
        //Method to change the theme name
        Long idToFind= theme.getId();
        Optional<Theme>themeToEdit = this.themeRepository.findById(idToFind);
        themeToEdit.get().setName(name);
        this.themeRepository.save(themeToEdit.get());
    }

    @Override
    public void remove(Theme theme) {
        //Method to remove a theme by name
        Theme themeToRemove = this.themeRepository.getThemeByThemeName(theme.getName());
        themeRepository.delete(themeToRemove);

    }

    @Override
    public Iterable<Theme> getAll() {
        //Method to get all themes
        Iterable<Theme>themes=themeRepository.findAll();
        return themes;
    }
}
