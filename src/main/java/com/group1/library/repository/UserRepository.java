package com.group1.library.repository;

import com.group1.library.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    User getUserByEmail(String email);

//    User getUserById(Long id); TODO Find in crudRepository

}
