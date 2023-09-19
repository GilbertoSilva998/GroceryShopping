/**
 * AdminFactoryTest.java
 * This is a test class for AdminFactory entity
 *
 * @author Anathi Mhlom 220006695
 * 07 April 2023
 */
package factory;

import za.ac.cput.domain.Admin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.factory.AdminFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class AdminFactoryTest {
    private Admin admin1;
    private Admin admin2;
    private Admin admin3;

    @BeforeEach
    void setUp() {
        admin1 = new Admin();
        admin2 = new Admin();
        admin3 = admin1;
    }

    @Test
    public void test() {
        Admin admin = AdminFactory.createAdmin("Tati", "Richflexbaybay!", "tatiflex@gmail.com", "0763265478");
        assert admin != null;
        System.out.println(admin);
        assertNotNull(admin);
    }

    @Test
    void testEquality() {
        assertEquals(admin1, admin3);
        System.out.println("Is equal");
    }

    @Test
    void testIdentity() {
        assertSame(admin1, admin3);
        System.out.println("Is the same");
    }

    @Test
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    void testTimeout() {
        System.out.println("Timeout has passed");
    }

    @Test
    @Disabled("Test is disabled")
    void testDisabled() {
        assertSame(admin1, admin2);
    }
}