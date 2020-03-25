package com.group1.library.service.inter;

import com.group1.library.entity.Admin;
import com.group1.library.exception.alreadyexists.AdminAlreadyExistsException;

public interface AdminService {

    public void addAdmin(Admin admin) throws AdminAlreadyExistsException, AdminAlreadyExistsException;

    public void removeAdminById(Long id);

    public void removeAdminByUsername(String username);

    public Admin findAdminById(Long id);

    public Admin findAdminByUsername(String username);

    public void updateAdminById(Long id,String password);

    public void updateAdminByUsername(String username,String password);

    public Iterable<Admin> findAll();
}
