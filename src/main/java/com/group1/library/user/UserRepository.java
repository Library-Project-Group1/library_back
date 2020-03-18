package com.group1.library.user;

import com.group1.library.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    User getUserByEmail(String email);





}
