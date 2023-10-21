package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Admin;
import za.ac.cput.factory.AdminFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest()
class AdminServiceTest {
    @Autowired
    private AdminService adminService;

    private static final Admin admin = AdminFactory.createAdmin("Jean", "Jean_1234", "jean@gmail.com", "0815691247");

    @Test
    void a_create() {
        Admin create = adminService.create(admin);
        assert admin != null;
        assertEquals(admin.getAdminId(), create.getAdminId());
        System.out.println("Created: " + create);
    }

    @Test
    void b_read() {
        assert admin != null;
        Admin read = adminService.read(admin.getAdminId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        assert admin != null;
        Admin newAdmin = new Admin.Builder().builder(admin).setAdminName("Athandile").build();
        Admin update = adminService.update(newAdmin);
        assertEquals(newAdmin.getAdminName(), update.getAdminName());
        System.out.println("Updated: " + update);
    }

    @Test
    @Disabled
    void e_delete() {
        assert admin != null;
        boolean adminDelete = adminService.delete(admin.getAdminId());
        assertTrue(adminDelete);
        System.out.println("Deleted: " + true);
    }

    @Test
    void d_getAll() {
        System.out.println("Get All: ");
        System.out.println(adminService.getAll());
    }
}