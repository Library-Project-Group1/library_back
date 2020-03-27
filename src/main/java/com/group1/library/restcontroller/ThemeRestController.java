package com.group1.library.restcontroller;

import com.group1.library.entity.Theme;
import com.group1.library.exception.alreadyexists.ThemeAlreadyExistsException;
import com.group1.library.exception.notfound.ThemeNotFoundException;
import com.group1.library.service.impl.ThemeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <code>Class ThemeRestController</code>
 * It returns all methods on themes in JSON format
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/apiThemes")
public class ThemeRestController {

    //Attribute
    @Autowired
    private ThemeServiceImpl themeService;

    /**
     * Method to create a theme in our library
     *
     * @param theme the theme to add in the stock
     * @return an instance of ResponseEntity
     */
    @PostMapping(path = "/createTheme", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> createTheme(@RequestBody @Valid Theme theme) {
        try {
            this.themeService.add(theme);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (ThemeAlreadyExistsException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    /**
     * Method to find a theme by his id
     *
     * @param id the id of the theme to find in the stock
     * @return a theme to find
     */

    @GetMapping("/theme/{id}")
    //method to get theme by id with exception not found
    public Theme findThemeById(@PathVariable Long id) {
        try {
            return themeService.getById(id);
        } catch (ThemeNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method to update a theme
     *
     * @param id the id of the theme to update
     * @param newTheme change the theme to a newTheme with others attributes
     */

    @PutMapping(value = "/theme/{id}/editTheme", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateThemeById(@PathVariable("id") Long id, @RequestBody @Valid Theme newTheme) {
        //Method to update the name of a theme thanks to his id
        try {
            themeService.editById(id, newTheme);
        } catch (ThemeNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to delete a theme
     *
     * @param id the id of the theme to delete
     */

    @DeleteMapping("/deleteTheme/{id}")
    public void deleteThemeById(@PathVariable Long id) {
        try {
            themeService.removeById(id);
        } catch (ThemeNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to get all themes
     *
     * @return A list of themes
     */

    @GetMapping("/allThemes")
    //method to get all themes
    public Iterable<Theme> findAllThemes() {
        return themeService.getAll();
    }
}
