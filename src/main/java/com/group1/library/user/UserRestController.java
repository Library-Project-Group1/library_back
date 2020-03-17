package com.group1.library.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // TODO compléter l'URL plus tard quand on aura plus de visibilité sur le changement de pages
public class UserRestController {
    //ATTRIBUTESs
    @Autowired
    UserService userService;

    //METHODS
    @PostMapping(value = "/createUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        //Method to create a new user
        try {
            this.userService.addUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping("/deleteUser")
    public void deleteUserById(Long id){
        //Method to delete a user by his id
        this.userService.removeUserById(id);
    }

    @GetMapping("/deleteUser2")
    public void deleteUserByEmail(String email){
        //Method to delete a user by his email
        this.userService.removeUserByEmail(email);
    }

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable("id") Long id){
        //Method to find a user by his id
        User userToFind= this.userService.findUserById(id);
        return userToFind;
    }

    public User findUserByEmail(String email){
        //Method to find a user by his email
        User userToFind=this.userService.findUserByEmail(email);
        Long idUser = userToFind.getId();
        return this.findUserById(idUser);
    }

    @PostMapping(value = "/user/{id}/editaccount", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateUserById(@PathVariable("id") Long id,String newPassword){
        //Method to update the password of a user thanks to his id
        this.userService.updateUserById(id,newPassword);
    }


    public void updateUserByEmail(String email,String newPassword){ // TODO On verra pour celle là si on peut pas l'intégrer à updateUserById je verrai plus tard je test angular
        //Method to update the password of a user thanks to his email
        this.userService.updateUserByEmail(email,newPassword);
    }

    @GetMapping("/allUsers")
    public Iterable<User> findAllUsers(){
        //Method to get all users
        return userService.getAllUsers();
    }
}
