package com.group1.library.service.inter;

import com.group1.library.entity.User;
import com.group1.library.exception.alreadyexists.UserAlreadyExistsException;
import com.group1.library.exception.notfound.UserNotFoundException;

public interface UserService {
    //

    public void addUser(User user) throws UserAlreadyExistsException;

    public void removeUserByEmail(String email) throws UserNotFoundException;

    public void removeUserById(Long id) throws UserNotFoundException;

    public User findUserById(Long id) throws UserNotFoundException;

    public User findUserByEmail(String email) throws UserNotFoundException;

    public void updateUserById(Long id, String newPassword) throws UserNotFoundException;

    public void updateUserByEmail(String email, String newPassword) throws UserNotFoundException;

    public Iterable<User> getAllUsers();
}
