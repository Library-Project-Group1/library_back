package com.group1.library.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserRestController {
    //ATTRIBUTES
    @Autowired
    UserService userService;

    //METHODS
    public void createUser(User user){
        //Method to create a new user
        userService.addUser(user);
    }

    public void deleteUserById(Long id){
        //Method to delete a user by his id
        userService.removeUserById(id);
    }

    public void deleteUserByEmail(String email){
        //Method to delete a user by his email
        User userToRemove=userService.findUserByEmail(email);
        userService.removeUserByEmail(email);
    }

    public User findUserById(Long id){
        //Method to find a user by his id
        User userToFind= userService.findUserById(id);
        return userToFind;
    }

    public User findUserByEmail(String email){
        //Method to find a user by his email
        User userToFind=userService.findUserByEmail(email);
        return userToFind;
    }

    public void updateUserById(Long id,String newPassword){
        //Method to update the password of a user thanks to his id
        userService.updateUserById(id,newPassword);
    }

    public void updateUserByEmail(String email,String newPassword){
        //Method to update the password of a user thanks to his email
        userService.updateUserByEmail(email,newPassword);
    }

    public Iterable<User> findAllUsers(){
        //Method to get all users
        return userService.getAllUsers();
    }
}
