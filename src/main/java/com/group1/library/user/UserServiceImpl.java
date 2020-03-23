package com.group1.library.user;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    //ATTRIBUTES
    @Autowired
    private UserRepository repository;

    //METHODS
    @Override
    /**
     * Method to add a new product in database
     * if the product is null, we save the products
     * @param user
     * @throws UserAlreadyExistsException if the product already exist
     */
    public void addUser(User user) throws UserAlreadyExistsException {
        //Method to add a user in our database
        User newUser=this.repository.getUserByEmail(user.getEmail());
        if (newUser==null) {
            this.repository.save(user);
        }else{
            throw new UserAlreadyExistsException();
        }
    }

    @Override
    /**
     * Method to remove a new product in database
     * if the product is null, we save the products
     * @param email
     */
    public void removeUserByEmail(String email) throws UserNotFoundException {
        //Method to remove a user by his email
        User userToRemove=this.repository.getUserByEmail(email);
        if(userToRemove==null){
            throw new UserNotFoundException();
        }else {
            this.repository.deleteById(userToRemove.getId());
        }
    }

    @Override
    public void removeUserById(Long id) throws UserNotFoundException {
        //Method to remove a user by his id
        if(this.repository.findById(id).isPresent()){
            this.repository.deleteById(id);
        }else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public User findUserById(Long id) throws UserNotFoundException {
        //Method to find a user thanks to his id
        Optional<User> optionalUser= this.repository.findById(id);
        if(!optionalUser.isPresent()){
            throw new UserNotFoundException();
        }else {
            User userToFind = optionalUser.get();
            return userToFind;
        }
    }

    @Override
    public User findUserByEmail(String email) throws UserNotFoundException {
        //Method to find a user thanks to his email
        User userToFind=this.repository.getUserByEmail(email);
        if(userToFind==null){
            throw  new UserNotFoundException();
        }else {
            return userToFind;
        }
    }

    @Override
    public void updateUserById(Long id,String newPassword) throws UserNotFoundException {
        //Method to update the password of a user thanks to his id
        Optional<User> optionalUser = this.repository.findById(id);
        if(!optionalUser.isPresent()){
            throw new UserNotFoundException();
        }else {
            User userToUpdate = optionalUser.get();
            userToUpdate.setPassword(newPassword);
            this.repository.save(userToUpdate);
        }
    }

    @Override
    public void updateUserByEmail(String email,String newPassword) throws UserNotFoundException {
        //Method to update the password of a user thanks to his email
        User userToUpdate=this.repository.getUserByEmail(email);
        if(userToUpdate==null){
            throw new UserNotFoundException();
        }else {
            userToUpdate.setPassword(newPassword);
            this.repository.save(userToUpdate);
        }
    }

    @Override
    public Iterable<User> getAllUsers(){
        //Method to get all users in our databse
        return this.repository.findAll();
    }
}
