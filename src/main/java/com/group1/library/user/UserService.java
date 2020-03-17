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
        //Method to add a user in our database
        User newUser=repository.getUserByEmail(user.getEmail());
        if (newUser==null) {
            repository.save(user);
        }else{
            System.out.println("USER ALREADY EXIST !!!");
        }
    }

    public void removeUserByEmail(String email){
        //Method to remove a user by his email
        User userToRemove=repository.getUserByEmail(email);
        repository.deleteById(userToRemove.getId());
    }

    public void removeUserById(Long id){
        //Method to remove a user by his id
        repository.deleteById(id);
    }

    public User findUserById(Long id){
        //Method to find a user thanks to his id
        Optional<User> optionalUser= repository.findById(id);
        User userToFind= optionalUser.get();
        return userToFind;
    }

    public User findUserByEmail(String email){
        //Method to find a user thanks to his email
        User userToFind=repository.getUserByEmail(email);
        return userToFind;
    }

    public void updateUserById(Long id,String newPassword){
        //Method to update the password of a user thanks to his id
        Optional<User> optionalUser=repository.findById(id);
        User userToUpdate=optionalUser.get();
        userToUpdate.setPassword(newPassword);
        repository.save(userToUpdate);
    }

    public void updateUserByEmail(String email,String newPassword){
        //Method to update the password of a user thanks to his email
        User userToUpdate=repository.getUserByEmail(email);
        userToUpdate.setPassword(newPassword);
        repository.save(userToUpdate);
    }

    public Iterable<User> getAllUsers(){
        //Method to get all users in our databse
        return repository.findAll();
    }
}
