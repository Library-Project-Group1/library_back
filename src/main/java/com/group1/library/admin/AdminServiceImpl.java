package com.group1.library.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    //AtTTRIBUTES
    @Autowired
    private AdminRepository adminRepository;

    //METHODS
    @Override
    public void addAdmin(Admin admin) throws AdminAlreadyExists {
        Admin adminTest=this.adminRepository.getAdminByUsername(admin.username);
        if(adminTest==null) {
            this.adminRepository.save(admin);
        }else{
            throw new AdminAlreadyExists();
        }
    }

    @Override
    public void removeAdminById(Long id) {
        this.adminRepository.deleteById(id);
    }

    @Override
    public void removeAdminByUsername(String username) {
        Admin adminToRemove=this.findAdminByUsername(username);
        this.adminRepository.delete(adminToRemove);
    }

    @Override
    public Admin findAdminById(Long id) {
        Optional<Admin> optionalAdmin=this.adminRepository.findById(id);
        Admin adminToFound= optionalAdmin.get();
        return adminToFound;
    }

    @Override
    public Admin findAdminByUsername(String username) {
        Admin adminToFound=this.adminRepository.getAdminByUsername(username);
        return adminToFound;
    }

    @Override
    public void updateAdminById(Long id,String password) {
        Optional<Admin> optionalAdmin=this.adminRepository.findById(id);
        Admin adminToUpdate=optionalAdmin.get();
        adminToUpdate.setPassword(password);
        this.adminRepository.save(adminToUpdate);
    }

    @Override
    public void updateAdminByUsername(String username,String password) {
        Admin adminToUpdate=this.findAdminByUsername(username);
        adminToUpdate.setPassword(password);
        this.adminRepository.save(adminToUpdate);
    }

    @Override
    public Iterable<Admin> findAll() {
        return this.adminRepository.findAll();
    }
}
