package com.group1.library;

import com.group1.library.admin.Admin;
import com.group1.library.admin.AdminRestController;
import com.group1.library.admin.AdminServiceImpl;
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
@ComponentScan(basePackages = "com.group1.library.admin")
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
        System.out.println("****** INTIATION SUCCESFULL !!!*********");


    }

    @Bean
    public CommandLineRunner demo(AdminRestController adminRestController) {
        Admin admin=new Admin("Bastien","password");
        adminRestController.createAdmin(admin);

        return args -> {
        };
    }

}
