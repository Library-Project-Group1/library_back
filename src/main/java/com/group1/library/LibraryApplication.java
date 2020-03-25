package com.group1.library;


import com.group1.library.exception.alreadyexists.ThemeAlreadyExistsException;
import com.group1.library.exception.notfound.ThemeNotFoundException;

import com.group1.library.service.impl.ThemeServiceImpl;
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
@ComponentScan(basePackages = "com.group1.library.entity")
@ComponentScan(basePackages = "com.group1.library.service.impl")
@ComponentScan(basePackages = "com.group1.library.restcontroller")
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
        System.out.println("****** INTIATION SUCCESFULL !!!*********");
    }


//    @Bean
//    public CommandLineRunner demoProduct(ProductRestController productRestController) {
//        Product product = new Product("Harry Potter", "jk Rowling", 23.6f);
//        productRestController.createProduct(product);
//        return args -> {};
//    }
//    @Bean
//    public void demo(ProductRestController productRestController) {}
//    public CommandLineRunner demo(UserRestController UserRestController){
//        return args -> {
//        };
//    }



//    @Bean
//    public CommandLineRunner demo2(TransactionServiceImpl transactionService) {
//        System.out.println(transactionService.findTransactionById(4l));
//
//
//        return args -> {
//        };
//    }

//    @Bean
//    public CommandLineRunner demo2(TransactionServiceImpl transactionService) {
//        System.out.println(transactionService.findTransactionById(4l));
//        return args -> {
//        };
//    }

//    @Bean

//    public CommandLineRunner demoTheme(ThemeServiceImpl themeService){
//        try {
//            themeService.getById(2L);
//        } catch (ThemeNotFoundException e) {
//            e.printStackTrace();
//        }
//        return args -> {
//        };
//    }
//    @Bean
//    public CommandLineRunner demoTheme(ThemeServiceImpl themeService) throws ThemeAlreadyExistsException, ThemeNotFoundException {
//
//
//        themeService.editById(14L,"patate");
//
//        return args -> {
//
//        };
////   }
//
//    }
}
