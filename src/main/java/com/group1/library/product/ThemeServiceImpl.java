package com.group1.library.product;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ThemeServiceImpl implements AttributeProductService<Theme,Long> {


    @Autowired
    private ThemeRepository themeRepository;


    @Override
    public Theme add(Theme theme) {
        themeRepository.save(theme);
        return theme;
    }

    @Override
    public Theme getById(Long id) {
        Optional<Theme>theme = themeRepository.findById(id);
        Theme themeToFind = theme.get();
        return themeToFind;
    }

    @Override
    public void edit(Theme theme) {
        Theme themeToEdit =
    }

    @Override
    public void remove(Theme theme) {

    }

    @Override
    public List<Theme> getAll() {
        return null;
    }
}
