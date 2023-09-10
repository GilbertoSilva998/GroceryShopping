/**
 * UserFactoryTest.java
 * This is a test class for UserFactory entity
 *
 * @author Anathi Mhlom 220006695
 * 07 April 2023
 */
package factory;

import za.ac.cput.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.factory.UserFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class UserFactoryTest {
    private User user1;
    private User user2;
    private User user3;

    @BeforeEach
    void setUp() {
        user1 = new User();
        user2 = new User();
        user3 = user1;
    }

    @Test
    public void test() {
        User user = UserFactory.createUser("Anathi", "21 Do Your Thing Street, Cape Town, 7741", "anathi21@gmail.com", "0612120020");
        assert user != null;
        System.out.println(user);
        assertNotNull(user);
    }

    @Test
    void testEquality() {
        assertEquals(user1, user3);
        System.out.println("Is equal");
    }

    @Test
    void testIdentity() {
        assertSame(user1, user3);
        System.out.println("Is the same");
    }

    @Test
    void testFail() {
        assertEquals(user1, user2);
        System.out.println("Test failed");
    }

    @Test
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    void testTimeout() {
        System.out.println("Timeout has passed");
    }
}