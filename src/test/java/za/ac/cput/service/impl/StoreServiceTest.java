package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Store;
import za.ac.cput.factory.StoreFactory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.service.impl.StoreService;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class StoreServiceTest {

    @Autowired
    private static StoreService service;
    private static Store store = StoreFactory.createStore("Shoprite", "Woodstock", "Retail Store");

    @Test
    void a_create() {
        Store created = service.create(store);
        assertEquals(store.getStoreId(), created.getStoreId());
        System.out.println( "Created: " + created);
    }

    @Test
    void b_read() {

        Store read = service.read(store.getStoreId());
        assertNotNull(read);
        System.out.println( "Created: " + read);

    }

    @Test
    @Disabled
    void c_delete() {
        boolean success = service.delete(store.getStoreId());
        assertTrue(success);
        System.out.println("Deleted: " + success);

    }
}