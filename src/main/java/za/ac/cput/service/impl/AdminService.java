package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Admin;
import za.ac.cput.repository.IAdminRepository;
import za.ac.cput.service.IAdminService;

import java.util.List;
import java.util.Set;

@Service
public class AdminService implements IAdminService {
    private IAdminRepository adminRepo;

    @Autowired
    private AdminService(IAdminRepository adminRepo) {
        this.adminRepo = adminRepo;
    }

    @Override
    public Admin create(Admin admin) {
        return this.adminRepo.save(admin);
    }

    @Override
    public Admin read(String adminId) {
        return this.adminRepo.findById(adminId).orElse(null);
    }

    @Override
    public Admin update(Admin admin) {
        if (this.adminRepo.existsById(admin.getAdminId()))
            return this.adminRepo.save(admin);
        return null;
    }

    @Override
    public boolean delete(String adminId) {
        if (this.adminRepo.existsById(adminId)) {
            this.adminRepo.deleteById(adminId);
            return true;
        }
        return false;
    }

    @Override
    public List<Admin> getAll() {
        return this.adminRepo.findAll();
    }
}