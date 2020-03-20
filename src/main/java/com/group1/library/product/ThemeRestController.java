package com.group1.library.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Theme RestController
 */
@RestController
public class ThemeRestController {

    //Attribute
    @Autowired
    private ThemeServiceImpl themeService;

    @PostMapping(path = "/themes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createTheme(@RequestBody @Valid Theme theme) {
        try {
            themeService.add(theme);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (ThemeAlreadyExistsException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }


    @GetMapping("/themes/{id}")
    //method to get theme by id with exception not found
    public Theme findThemeById(@PathVariable Long id) {
        try {
            return themeService.getById(id);
        } catch (ThemeNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
        @DeleteMapping("/themes/{id}")
        public void deleteTheme (@PathVariable Long id){
            themeService.removeById(id);
        }

        @PostMapping("/themes/{id}")
        public void editThemeById(@PathVariable("id") Long id, @RequestBody String newName){
            try {
                Theme themeToEdit = themeService.getById(id);

                themeService.editById(themeToEdit.getId(), newName);

            } catch (ThemeNotFoundException e) {
                e.printStackTrace();
            }
        }

        @DeleteMapping("/themes/{id}")
        public void deleteThemeById (@PathVariable Long id){
            themeService.removeById(id);
        }

        @RequestMapping("/themes")
        //method to get all themes
        public Iterable<Theme> findAllThemes () {
            return themeService.getAll();
        }
    }
