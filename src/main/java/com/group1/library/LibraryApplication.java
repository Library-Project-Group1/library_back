package com.group1.library;

import com.group1.library.admin.Admin;
import com.group1.library.admin.AdminRestController;
import com.group1.library.admin.AdminServiceImpl;
import com.group1.library.product.*;
import com.group1.library.transaction.Transaction;
import com.group1.library.transaction.TransactionRepositry;
import com.group1.library.transaction.TransactionRestController;
import com.group1.library.transaction.TransactionServiceImpl;
import com.group1.library.user.User;
import com.group1.library.user.UserAlreadyExistsException;
import com.group1.library.user.UserRestController;
//import com.group1.library.user.UserService;
import com.group1.library.user.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.group1.library.product")
//@ComponentScan(basePackages = "com.group1.library.user")
@ComponentScan(basePackages = "com.group1.library.user")
@ComponentScan(basePackages = "com.group1.library.admin")
@ComponentScan(basePackages = "com.group1.library.transaction")
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



    /*
    @Bean
    public CommandLineRunner demo2(TransactionRestController transactionRestController) {
        User user=new User("BastienPuigrodon", "azerty");
        Product product=new Product();
        product.setId(2l);
        Transaction transaction=new Transaction();
        System.out.println(transactionRestController.getAll());




        return args -> {
        };
    }*/

    // COMMENTAIRE POUR TESTS
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
//   @Bean
//   public CommandLineRunner demoUser(ThemeServiceImpl themeService) throws ThemeAlreadyExistsException, ThemeNotFoundException {
//        Theme theme=new Theme("SF");
//        System.out.println(themeService.getById(1l));
//        return args -> {
//
//       };
//   }

}
