package com.group1.library.service.impl;

import com.group1.library.entity.Admin;
import com.group1.library.exception.alreadyexists.AdminAlreadyExistsException;
import com.group1.library.repository.AdminRepository;
import com.group1.library.service.inter.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <code>Class AdminServiceImpl</code> defines...
 */
@Service
public class AdminServiceImpl implements AdminService {

    // ATTRIBUTE
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public void addAdmin(Admin admin) throws AdminAlreadyExistsException {
        Admin adminTest = this.adminRepository.getAdminByUsername(admin.getUsername());
        if (adminTest == null) {
            this.adminRepository.save(admin);
        } else {
            throw new AdminAlreadyExistsException();
        }
    }

    @Override
    public void removeAdminById(Long id) {
        this.adminRepository.deleteById(id);
    }

    @Override
    public void removeAdminByUsername(String username) {
        Admin adminToRemove = this.findAdminByUsername(username);
        this.adminRepository.delete(adminToRemove);
    }

    @Override
    public Admin findAdminById(Long id) {
        Optional<Admin> optionalAdmin = this.adminRepository.findById(id);
        Admin adminToFound = optionalAdmin.get();
        return adminToFound;
    }

    @Override
    public Admin findAdminByUsername(String username) {
        Admin adminToFound = this.adminRepository.getAdminByUsername(username);
        return adminToFound;
    }

    @Override
    public void updateAdminById(Long id, String password) {
        Optional<Admin> optionalAdmin = this.adminRepository.findById(id);
        Admin adminToUpdate = optionalAdmin.get();
        adminToUpdate.setPassword(password);
        this.adminRepository.save(adminToUpdate);
    }

    @Override
    public void updateAdminByUsername(String username, String password) {
        Admin adminToUpdate = this.findAdminByUsername(username);
        adminToUpdate.setPassword(password);
        this.adminRepository.save(adminToUpdate);
    }

    @Override
    public Iterable<Admin> findAll() {
        return this.adminRepository.findAll();
    }
}
