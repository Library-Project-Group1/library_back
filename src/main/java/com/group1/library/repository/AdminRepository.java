package com.group1.library.repository;

import com.group1.library.entity.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin,Long> {

    public Admin getAdminByUsername(String username);
}
