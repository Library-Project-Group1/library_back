package com.group1.library.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/apiAdmins")
public class AdminRestController {
    //ATTRIBUTES
    @Autowired
    private AdminServiceImpl adminService;

    //METHODS
    @PostMapping(value = "/createAdmin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createAdmin(@Valid @RequestBody Admin admin){
        try {
            this.adminService.addAdmin(admin);
        }catch (AdminAlreadyExists e){
            e.printStackTrace();
        }
    }

    @DeleteMapping("/deleteAdmin/{id}")
    public void deleteAdminById(@PathVariable("id") Long id) {
        this.adminService.removeAdminById(id);
    }

    @DeleteMapping("/deleteAdmin/{username}")
    public void deleteAdminByUsername(@PathVariable("username") String username) {
        this.adminService.removeAdminByUsername(username);
    }

    @GetMapping("/admin/{id}")
    public Admin findAdminById(@PathVariable("id") Long id) {
        Admin adminToFind=this.adminService.findAdminById(id);
        return adminToFind;
    }

    @GetMapping("/admin/{username}")
    public Admin findAdminByUsername(@PathVariable("username") String username) {
        Admin adminToFind=this.adminService.findAdminByUsername(username);
        return adminToFind;
    }

    @PutMapping(value = "/admin/{id}/editaccount", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateAdminById(@PathVariable("id") Long id,String password) {
        this.adminService.updateAdminById(id,password);
    }

    @PutMapping(value = "/admin/{username}/editaccount", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateAdminByUsername(@PathVariable("username") String username,String password) {
        this.adminService.updateAdminByUsername(username,password);
    }

    @GetMapping("/allAdmins")
    public Iterable<Admin> findAllAdmins() {
        return this.adminService.findAll();
    }

}
