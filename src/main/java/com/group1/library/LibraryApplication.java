package com.group1.library;

import com.group1.library.user.User;
import com.group1.library.user.UserRepository;
import com.group1.library.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.group1.library.user")
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
        System.out.println("****** INTIATION SUCCESFULL !!!*********");




    }

    @Bean
    public CommandLineRunner demo(UserService userService){
        User user=new User("bastien@email.com","password");
        userService.addUser(user);
        return args -> {

        };
    }
}