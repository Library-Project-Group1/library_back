package com.group1.library.service.impl;

import com.group1.library.entity.Theme;
import com.group1.library.exception.alreadyexists.ThemeAlreadyExistsException;
import com.group1.library.exception.notfound.ThemeNotFoundException;
import com.group1.library.repository.ThemeRepository;
import com.group1.library.service.inter.AttributeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <code>Class ThemeServiceImpl</code> defines all possible operations on themes of the library.
 */
@Service
public class ThemeServiceImpl implements AttributeProductService<Theme, Long> {

    // ATTRIBUTES
    @Autowired
    private ThemeRepository themeRepository;

    /**
     * Method to add a new theme in the database.
     * If the the theme doesn't already exist, the theme is created and save in database otherwise an exception is thrown.
     *
     * @param theme the theme to add in the database.
     * @return the theme to add into the save method
     * @throws ThemeAlreadyExistsException if the theme already exist in the database.
     */
    @Override
    public Theme add(Theme theme) throws ThemeAlreadyExistsException {
        Theme themeToAdd = themeRepository.getThemeById(theme.getId());
        if (themeToAdd == null) {

            this.themeRepository.save(theme);
            return theme;
        } else {
            throw new ThemeAlreadyExistsException();
        }
    }

    /**
     * Method to find a theme with the id in the database.
     *
     * @param id the id of the theme to get in the database
     * @return An instance of theme, which corresponds to the theme to find in database.
     * @throws ThemeNotFoundException if the theme cannot be found in the database.
     */
    @Override
    public Theme getById(Long id) throws ThemeNotFoundException {
        Optional<Theme> theme = this.themeRepository.findById(id);
        if (theme.isPresent()) {
            Theme themeToFind = theme.get();
            return themeToFind;
        } else {
            throw new ThemeNotFoundException();
        }
    }

    /**
     * Method to edit a theme by its id element in the database.
     * If the theme already exist, his parameters is changed by the newTheme
     * @param id       the id of the theme to edit in the database.
     * @param newTheme the theme with the new parameters to edit.
     * @throws ThemeNotFoundException if the theme cannot be found in database.
     */
    @Override
    public void editById(Long id, Theme newTheme) throws ThemeNotFoundException {
        Optional<Theme> themeToEdit = this.themeRepository.findById(id);
        if (!themeToEdit.isPresent()) {
            throw new ThemeNotFoundException();
        } else {
            themeToEdit.get().setName(newTheme.getName());
            this.themeRepository.save(themeToEdit.get());
        }
    }

    /**
     * Method to delete a theme by its id element in the database.
     *
     * @param id the id of the theme to delete in the database.
     * @throws ThemeNotFoundException if the theme cannot be found in database.
     */
    @Override
    public void removeById(Long id) throws ThemeNotFoundException {
        Theme themeToDelete = this.themeRepository.getThemeById(id);
        if(themeToDelete == null){
            throw new ThemeNotFoundException();
        }
        themeRepository.deleteById(id);
    }

    /**
     * Method that retrieves all themes list in database.
     * @return the list of all themes.
     */
    @Override
    public Iterable<Theme> getAll() {
        return this.themeRepository.findAll();
    }
}
