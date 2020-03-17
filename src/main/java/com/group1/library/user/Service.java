package com.group1.library.user;

public interface Service {

    public void addUser(User user);

    public void removeUserByEmail(String email);

    public void removeUserById(Long id);

    public User findUserById(Long id);

    public User findUserByEmail(String email);

    public void updateUserById(Long id,String newPassword);

    public void updateUserByEmail(String email,String newPassword);

    public Iterable<User> getAllUsers();

}
