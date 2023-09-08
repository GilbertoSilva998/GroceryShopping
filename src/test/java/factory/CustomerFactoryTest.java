/**
 * CustomerfactoryTest.java
 * This is a test class for CustomerFactory
 * @author Sinentlahla Pindani 219081328
 * 08 April 2023
 */
package factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {
    private Customer customer1;
    private Customer customer2;
    private Customer customer3;

    @BeforeEach
    void setUp() {
        customer1 = new Customer() ;
        customer2 = new Customer() ;
        customer3 = customer1;

    }

    @Test
    public void test(){
        Customer customer = CustomerFactory.createCustomer("Sinentlahla","Pindani","0786236823","SinentlahlaPindani@gmail.com","DT498 SiteC Khayelitsha");
        System.out.println(customer.toString());
        assertNotNull(customer);
    }

    @Test
    void testEquality(){
        assertEquals(customer1,customer3);
    }

    @Test
    void testIdentity(){
        assertSame(customer1,customer3);
    }
    //Test fail, meant to fail
    @Test
    public void testFail(){
        fail("This is meant to fail");
    }

    //Test timeout, meant to skip
    @Test
    @Timeout(1)
    void testTimeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);
    }

    //Desiabled test, meant to skip
    @Disabled("Disabled test")
    @Test
    void testDisable() {
        assertEquals(customer1, customer2);
    }



}