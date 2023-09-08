package repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.repository.CustomerRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class CustomerRepositoryTest {
    private static CustomerRepository repository = CustomerRepository.getRepository();
    private static Customer customer = CustomerFactory.createCustomer("Anelisa","Sonjica","0835228010", "Annia@gmail.com","DT854 Site C khayelitsha ");
    @Test
    void a_create() {
        Customer created = repository.create(customer) ;
        assertEquals(customer.getCustomerId(), created.getCustomerId());
        System.out.println("Create:" + created);
    }

    @Test
    void b_read() {

        Customer read = repository.read(customer.getCustomerId()) ;
        assertNotNull(read);
        System.out.println("Read:" + read);
    }

    @Test
    void c_update() {
        Customer updated = new Customer.Builder().copy(customer).setFirstName("Sinazo")
                .setLastName("Manga")
                .setPhone("0733452765")
                .setEmail("sinazomanga@gmail.com")
                .setAddress("1537 Nzinziniba Phillip")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated:" + updated);


    }

    @Test
    void e_delete() {
        boolean success = repository.delete(customer.getCustomerId());
        assertTrue(success);
        System.out.println("Deleted:" + success);

    }

    @Test
    void d_getAll() {


    }
}