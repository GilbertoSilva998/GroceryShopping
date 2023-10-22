package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Admin;
import za.ac.cput.exception.AdminNotFoundException;
import za.ac.cput.repository.IAdminRepository;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:3000")
public class AdminController {

    @Autowired
    private IAdminRepository adminRepository;

    @PostMapping("/admin")
    Admin newAdmin(@RequestBody Admin newAdmin){
        return adminRepository.save(newAdmin);
    }

    @GetMapping("/admins")
    List<Admin> getAllAdmins(){
        return adminRepository.findAll();
    }

    @GetMapping("/admin/{id}")
    Admin getAdminById(@PathVariable Long id){
        return adminRepository.findById(String.valueOf(id))
                .orElseThrow(()->new AdminNotFoundException(id));
    }

    @PutMapping("/admin/{id}")
    Admin updateAdmin(@RequestBody Admin newAdmin, @PathVariable Long id){
        return adminRepository.findById(String.valueOf(id))
                .map(admin -> {
                    admin.setAdminName(newAdmin.getAdminName());
                    admin.setAdminEmail(newAdmin.getAdminEmail());
                    admin.setAdminPhone(newAdmin.getAdminPhone());
                    admin.setAdminPassword(newAdmin.getAdminPassword());
                    return adminRepository.save(admin);
                }).orElseThrow(()->new AdminNotFoundException(id));
    }

    @DeleteMapping("/admin/{id}")
    String deleteAdmin(@PathVariable Long id){
        if (!adminRepository.existsById(String.valueOf(id))){
            throw new AdminNotFoundException(id);
        }
        adminRepository.deleteById(String.valueOf(id));
        return "Admin with id " +id+ " has been deleted successfully.";
    }

    /* @Autowired
    private AdminService adminService;

    @PostMapping("/create")
    public Admin create(@RequestBody Admin admin) {
        return adminService.create(admin);
    }

    @GetMapping("/read/{adminId}")
    public Admin read(@PathVariable String adminId) {
        return adminService.read(adminId);
    }

    @PostMapping("/update")
    public Admin update(@RequestBody Admin admin) {
        return adminService.update(admin);
    }

    @DeleteMapping("/delete/{adminId}")
    public boolean delete(@PathVariable String adminId) {
        return adminService.delete(adminId);
    }

    @GetMapping("/getAll")
    public List<Admin> getAll() {
        return adminService.getAll();
    } */
}