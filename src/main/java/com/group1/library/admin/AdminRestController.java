package com.group1.library.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AdminRestController {
    //ATTRIBUTES
    @Autowired
    private AdminServiceImpl adminService;

    //METHODS
    public void createAdmin(Admin admin){
        try {
            this.adminService.addAdmin(admin);
        }catch (AdminAlreadyExists e){
            e.printStackTrace();
        }
    }

    public void deleteAdminById(Long id) {
        this.adminService.removeAdminById(id);
    }

    public void deleteAdminByUsername(String username) {
        this.adminService.removeAdminByUsername(username);
    }

    public Admin findAdminById(Long id) {
        Admin adminToFind=this.adminService.findAdminById(id);
        return adminToFind;
    }

    public Admin findAdminByUsername(String username) {
        Admin adminToFind=this.adminService.findAdminByUsername(username);
        return adminToFind;
    }

    public void updateAdminById(Long id,String password) {
        this.adminService.updateAdminById(id,password);
    }

    public void updateAdminByUsername(String username,String password) {
        this.adminService.updateAdminByUsername(username,password);
    }

    public Iterable<Admin> findAll() {
        return this.adminService.findAll();
    }

}
