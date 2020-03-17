package com.group1.library.product;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ThemeServiceImpl implements AttributeProductService<Theme,Long> {

    //Attributes
    @Autowired
    private ThemeRepository themeRepository;

    //Methods
    @Override
    public Theme add(Theme theme) {
        //Method to add a 
        this.themeRepository.save(theme);
        return theme;
    }

    @Override
    public Theme getById(Long id) {
        Optional<Theme>theme = this.themeRepository.findById(id);
        Theme themeToFind = theme.get();
        return themeToFind;
    }

    @Override
    public void edit(Theme theme, String name) {
        Long idToFind= theme.getId();
        Optional<Theme>themeToEdit = this.themeRepository.findById(idToFind);
        themeToEdit.get().setName(name);
        this.themeRepository.save(themeToEdit.get());
    }

    @Override
    public void remove(Theme theme) {
        Theme themeToRemove = this.themeRepository.getThemeByThemeName(theme.getName());
        themeRepository.delete(themeToRemove);

    }



    @Override
    public Iterable<Theme> getAll() {
        Iterable<Theme>themes=themeRepository.findAll();
        return themes;
    }
}
