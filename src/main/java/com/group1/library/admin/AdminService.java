package com.group1.library.admin;

import org.springframework.stereotype.Service;

public interface AdminService {

    public void addAdmin(Admin admin) throws AdminAlreadyExists;

    public void removeAdminById(Long id);

    public void removeAdminByUsername(String username);

    public Admin findAdminById(Long id);

    public Admin findAdminByUsername(String username);

    public void updateAdminById(Long id,String password);

    public void updateAdminByUsername(String username,String password);

    public Iterable<Admin> findAll();
}
