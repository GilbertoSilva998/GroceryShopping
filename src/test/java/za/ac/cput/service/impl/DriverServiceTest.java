package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Driver;
import za.ac.cput.factory.DriverFactory;


import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class DriverServiceTest {

    @Autowired
    private DriverService service;

    private static Driver driver = DriverFactory.createDriver("Rick",
            "Ferdinand","11111","Benz",
            "0747823872","ri@gmail.com");
    @Test
    void a_create() {
        Driver created = service.create(driver);
        assertEquals(driver.getDriver_ID(), created.getDriver_ID());
        System.out.println("Created: " +created);
    }

    @Test
    void b_read() {
        Driver read = service.read(driver.getDriver_ID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Driver newDriver = new Driver.Builder().copy(driver).setFirst_Name("Ricardo").build();
        Driver updated = service.update(newDriver);
        assertEquals(newDriver.getFirst_Name(), updated.getFirst_Name());
        System.out.println("Updated: " + updated);
    }

    @Test
    @Disabled
    void e_delete() {
    }

    @Test
    void d_getAll() {
        System.out.println("Get all: ");
        System.out.println(service.getAll());
    }
}