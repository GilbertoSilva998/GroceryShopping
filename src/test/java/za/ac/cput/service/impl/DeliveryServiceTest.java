package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Delivery;
import za.ac.cput.factory.DeliveryFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class DeliveryServiceTest {

    @Autowired
    private  DeliveryService service;
    private static Delivery delivery = DeliveryFactory.createDelivery("78 Kenilworth",
            "12/12/2022","Monday","T-shirt","Mini Van");
    @Test
    void a_create() {
        Delivery created = service.create(delivery);
        assertEquals(delivery.getDeliveryId(), created.getDeliveryId());
        System.out.println ("Created: " + created);
    }

    @Test
    void b_read() {
        Delivery read = service.read(delivery.getDeliveryId());
        assertNotNull(read);
        System.out.println("Read" + read);
    }

    @Test
    void c_update() {
        Delivery newDelivery = new Delivery.Builder().builder(delivery).setDeliveryAddress("Bellville").build();
        Delivery updated = service.update(newDelivery);
        assertEquals(newDelivery.getDeliveryAddress(), updated.getDeliveryAddress());
        System.out.println("Updated: " +updated);
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