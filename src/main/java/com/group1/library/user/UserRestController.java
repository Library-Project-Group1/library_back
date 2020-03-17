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
        //METHOD TO ADD A USER IN OUR DATABASE
        userService.addUser(user);
    }

    public void deleteUserById(Long id){
        //METHOD TO REMOVE A USER BY HIS ID
        userService.removeUserById(id);
    }

    public void deleteUserByEmail(String email){
        //METHOD TO REMOVE A USER BY HIS EMAIL
        User userToRemove=userService.findUserByEmail(email);
        userService.removeUserByEmail(email);
    }

    public User findUserById(Long id){
        //METHOD TO FIND A USER THANKS TO HIS ID
        User userToFind= userService.findUserById(id);
        return userToFind;
    }

    public User findUserByEmail(String email){
        //METHOD TO FIND A USER THANKS TO HIS EMAIL
        User userToFind=userService.findUserByEmail(email);
        return userToFind;
    }

    public void updateUserById(Long id,String newPassword){
        //METHOD TO UPDATE THE PASSWORD OF A USER THANKS TO HIS ID
        userService.updateUserById(id,newPassword);
    }

    public void updateUserByEmail(String email,String newPassword){
        //METHOD TO UPDATE THE PASSWORD OF A USER THANKS TO HIS EMAIL
        userService.updateUserByEmail(email,newPassword);
    }

    public Iterable<User> findAllUsers(){
        //METHOD TO GET ALL USERS IN OUR DATABASE
        return userService.getAllUsers();
    }
}
