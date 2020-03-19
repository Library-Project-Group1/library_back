package com.group1.library;

import com.group1.library.product.*;
import com.group1.library.user.UserRestController;
//import com.group1.library.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.group1.library.product")
@ComponentScan(basePackages = "com.group1.library.user")
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
        System.out.println("****** INTIATION SUCCESFULL !!!*********");


    }

//    @Bean
//    public void demo(ProductRestController productRestController) {}
//    public CommandLineRunner demo(UserRestController UserRestController){
//        return args -> {
//        };
//    }

}
