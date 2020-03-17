package com.group1.library;

import com.group1.library.product.*;
import com.group1.library.user.User;
import com.group1.library.user.UserRepository;
import com.group1.library.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = "com.group1.library.product")
@ComponentScan(basePackages = "com.group1.library.user")
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
        System.out.println("****** INTIATION SUCCESFULL !!!*********");


    }

<<<<<<< HEAD
    @Bean
    public CommandLineRunner demoCat(CategoryServiceImpl catServImpl){
        catServImpl.edit(1L, "coucou");
        return args -> {
        };
    }

    @Bean
    public CommandLineRunner demoTheme(ThemeServiceImpl themeService){
        try {
            themeService.getById(2L);
        } catch (ThemeNotFoundException e) {
            e.printStackTrace();
        }
        return args -> {
        };
    }
=======
   @Bean
   public CommandLineRunner demoUser(ThemeServiceImpl themeService) throws ThemeAlreadyExistsException, ThemeNotFoundException {
        Theme theme=new Theme("SF");
        System.out.println(themeService.getById(1l));
        return args -> {

       };
   }

>>>>>>> 5f257d040080ce2dc1c8867dbb1baee88b3e0239

}
