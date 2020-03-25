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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/apiThemes")
public class ThemeRestController {

    //Attribute
    @Autowired
    private ThemeServiceImpl themeService;

    @PostMapping(path = "/createTheme", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> createTheme(@RequestBody @Valid Theme theme) {
        try {
            themeService.add(theme);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (ThemeAlreadyExistsException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }


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

    @PutMapping("/theme/{id}/editTheme")
    public void updateThemeById(@PathVariable("id") Long id, String newName) {
        //Method to update the name of a theme thanks to his id
        try {
           themeService.editById(id, newName);

        } catch (ThemeNotFoundException e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/deleteTheme/{id}")
    public void deleteThemeById(@PathVariable Long id) {
        themeService.removeById(id);
    }

    @GetMapping("/allThemes")
    //method to get all themes
    public Iterable<Theme> findAllThemes() {
        return themeService.getAll();
    }
}
