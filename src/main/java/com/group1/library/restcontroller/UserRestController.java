package com.group1.library.restcontroller;

import com.group1.library.entity.User;
import com.group1.library.exception.alreadyexists.UserAlreadyExistsException;
import com.group1.library.exception.notfound.UserNotFoundException;
import com.group1.library.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/apiUsers")
public class UserRestController {
    //ATTRIBUTES
    @Autowired
    private UserServiceImpl userServiceImpl;

    //METHODS
    @PostMapping(value = "/createUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        //Method to create a new user
        try {
            this.userServiceImpl.addUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (UserAlreadyExistsException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        //Method to delete a user by his id
        try {
            this.userServiceImpl.removeUserById(id);
        }catch (UserNotFoundException e){
            e.printStackTrace();
        }
    }

    @DeleteMapping("/deleteUser/{email}")
    public void deleteUserByEmail(@PathVariable("email") String email) {
        //Method to delete a user by his email
        try {
            this.userServiceImpl.removeUserByEmail(email);
        }catch (UserNotFoundException e){
            e.printStackTrace();
        }
    }

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable("id") Long id) {
        //Method to find a user by his id
        try {
            User userToFind = this.userServiceImpl.findUserById(id);
            return userToFind;
        }catch (UserNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/user/{email}")
    public User findUserByEmail(@PathVariable("email") String email) {
        //Method to find a user by his email
        try {
            User userToFind = this.userServiceImpl.findUserByEmail(email);
            Long idUser = userToFind.getId();
            return this.findUserById(idUser);
        }catch (UserNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping(value = "/user/{id}/editaccount", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateUserById(@PathVariable("id") Long id, String newPassword) {
        //Method to update the password of a user thanks to his id
        try {
            this.userServiceImpl.updateUserById(id, newPassword);
        }catch (UserNotFoundException e){
            e.printStackTrace();
        }
    }

    @PutMapping(value = "/user/{email}/editaccount", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateUserByEmail(@PathVariable("email") String email,String newPassword){
        //Method to update the password of a user thanks to his email
        try {
            this.userServiceImpl.updateUserByEmail(email, newPassword);
        }catch (UserNotFoundException e){
            e.printStackTrace();
        }
    }

    @GetMapping("/allUsers")
    public Iterable<User> findAllUsers(){
        //Method to get all users
        return userServiceImpl.getAllUsers();
    }
}
