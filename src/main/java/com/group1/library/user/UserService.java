package com.group1.library.user;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService{

    //ATTRIBUTES
    @Autowired
    private UserRepository repository;


    //METHODS
    public void addUser(User user){
        //METHOD TO ADD A NEW USER IN OUR DATABSE
        User newUser=repository.getUserByEmail(user.getEmail());
        if (newUser==null) {
            repository.save(user);
        }else{
            System.out.println("USER ALREADY EXIST !!!");
        }
    }

    public void removeUserByEmail(String email){
        //METHOD TO REMOVE A USER BY HIS EMAIL
        User userToRemove=repository.getUserByEmail(email);
        repository.deleteById(userToRemove.getId());
    }

    public void removeUserById(Long id){
        //METHOD TO REMOVE A USER BY HIS ID
        repository.deleteById(id);
    }

    public User findUserById(Long id){
        //METHOD TO FIND A USER THANKS TO HIS ID
        Optional<User> optionalUser= repository.findById(id);
        User userToFind= optionalUser.get();
        return userToFind;
    }

    public User findUserByEmail(String email){
        //METHOD TO FIND A USER THANKS TO HIS EMAIL
        User userToFind=repository.getUserByEmail(email);
        return userToFind;
    }

    public void updateUserById(Long id,String newPassword){
        //METHOD TO UPDATE THE PASSWORD OF A USER THANKS TO HIS ID
        Optional<User> optionalUser=repository.findById(id);
        User userToUpdate=optionalUser.get();
        userToUpdate.setPassword(newPassword);
        repository.save(userToUpdate);
    }

    public void updateUserByEmail(String email,String newPassword){
        //METHOD TO UPDATE THE PASSWORD OF A USER THANKS TO HIS EMAIL
        User userToUpdate=repository.getUserByEmail(email);
        userToUpdate.setPassword(newPassword);
        repository.save(userToUpdate);
    }

    public Iterable<User> getAllUsers(){
        //METHOD TO GET ALL USERS IN OUR DATABASE
        return repository.findAll();
    }
}
