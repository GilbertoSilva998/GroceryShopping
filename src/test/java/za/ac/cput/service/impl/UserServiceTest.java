package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.service.impl.UserService;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    private static final User user = UserFactory.createUser("Zaloluhle", "15 Pink Street, Cape Town, 8001", "zaloluhle@gmail.com", "0791452034");

    @Test
    void a_create() {
        User create = userService.create(user);;
        assertEquals(user.getUserId(), create.getUserId());
        System.out.println("Created: " + create);
    }

    @Test
    void b_read() {;
        User read = userService.read(user.getUserId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {;
        User newUser = new User.Builder().builder(user).setUserName("Olothando").build();
        User update = userService.update(newUser);
        assertEquals(newUser.getUserName(), update.getUserName());
        System.out.println("Updated: " + update);
    }

    @Test
    void e_delete() {;
        boolean userDelete = userService.delete(user.getUserId());
        assertTrue(userDelete);
        System.out.println("Deleted: " + true);
    }

    @Test
    void d_getAll() {
        System.out.println("Get All: ");
        System.out.println(userService.getAll());
    }
}