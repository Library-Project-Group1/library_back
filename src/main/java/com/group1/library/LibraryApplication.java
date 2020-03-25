package com.group1.library;

import com.group1.library.entity.Category;
import com.group1.library.entity.Product;
import com.group1.library.restcontroller.CategoryRestController;
import com.group1.library.restcontroller.ProductRestController;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.group1.library.product")
@ComponentScan(basePackages = "com.group1.library.user")
@ComponentScan(basePackages = "com.group1.library.admin")
@ComponentScan(basePackages = "com.group1.library.transaction")
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
        System.out.println("****** INTIATION SUCCESFULL !!!*********");
    }


    @Bean
    public CommandLineRunner demoProduct(ProductRestController productRestController) {
        Product product = new Product("Harry Potter", "jk Rowling", 23.6f);
        productRestController.createProduct(product);
        return args -> {};
    }
//    @Bean
//    public void demo(ProductRestController productRestController) {}
//    public CommandLineRunner demo(UserRestController UserRestController){
//        return args -> {
//        };
//    }

