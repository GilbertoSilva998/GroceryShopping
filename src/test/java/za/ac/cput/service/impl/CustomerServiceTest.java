package za.ac.cput.service.impl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.service.impl.CustomerService;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class CustomerServiceTest {
    @Autowired
    private CustomerService service;
    private static Customer customer = CustomerFactory.createCustomer("Sinentlahla","Pindani","0834254312","Sine@gmail.com","DT498 Site C Khayelitsha");
    @Test
    void a_create() {
        Customer created = service.create(customer);
        assertEquals(customer.getCustomerId(), created.getCustomerId());
        System.out.println("created:"+ created);
    }

    @Test
    void b_read() {
        Customer read = service.read(customer.getCustomerId());
        assertNotNull(read);
        System.out.println("Read:"+ read);
    }

    @Test
    void c_update() {
        Customer newCustomer = new Customer.Builder().copy(customer).setFirstName("Ntlahla").build();
        Customer updated= service.update(newCustomer);
        assertEquals(newCustomer.getFirstName(), updated.getFirstName());
        System.out.println("Updated:"+ updated);
    }

    @Test
    @Disabled
    void delete() {
    }

    @Test
    void d_getAll() {
        System.out.println("Show all");
        System.out.println(service.getAll());
    }
}
