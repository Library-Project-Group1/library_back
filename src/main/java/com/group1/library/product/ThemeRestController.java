package com.group1.library.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.util.Optional;

//Theme RestController
@RestController
public class ThemeRestController {

    //Attributes themeServices
    @Autowired
    private ThemeServiceImpl themeService;


    @RequestMapping("/themes")
    public Iterable<Theme> themes(){
        return themeService.getAll();
    }

    @GetMapping("/themes/{id}")
    public Theme findById(@PathVariable Long id){
        return themeService.getById(id);
    }

    @PostMapping(path = "/themes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createTheme(@RequestBody @Valid Theme theme){
        try{
            themeService.add(theme);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (ThemeAlreadyExistsException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @DeleteMapping("/themes/{id}")
    public void deleteTheme(@PathVariable Theme theme){
        themeService.remove(theme);
    }


}
