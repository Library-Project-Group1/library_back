package com.group1.library.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
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

    @GetMapping("/deleteUser")
    public void deleteUserById(Long id){
        //Method to delete a user by his id
        try {
            this.userServiceImpl.removeUserById(id);
        }catch (UserNotFoundException e){
            e.printStackTrace();
        }
    }

    @GetMapping("/deleteUser2")
    public void deleteUserByEmail(String email){
        //Method to delete a user by his email
        try {
            this.userServiceImpl.removeUserByEmail(email);
        }catch (UserNotFoundException e){
            e.printStackTrace();
        }
    }

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable("id") Long id){
        //Method to find a user by his id
        try {
            User userToFind = this.userServiceImpl.findUserById(id);
            return userToFind;
        }catch (UserNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

    public User findUserByEmail(String email){
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

    @PostMapping(value = "/user/{id}/editaccount", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    //TODO PutMapping
    public void updateUserById(@PathVariable("id") Long id,String newPassword){
        //Method to update the password of a user thanks to his id
        try {
            this.userServiceImpl.updateUserById(id, newPassword);
        }catch (UserNotFoundException e){
            e.printStackTrace();
        }
    }


    public void updateUserByEmail(String email,String newPassword){ // TODO On verra pour celle là si on peut pas l'intégrer à updateUserById je verrai plus tard je test angular
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
