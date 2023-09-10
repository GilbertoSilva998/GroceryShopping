package za.ac.cput.service.impl;

import za.ac.cput.domain.Store;
import za.ac.cput.factory.StoreFactory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.service.impl.StoreServiceImpl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.MethodName.class)
class StoreServiceImplTest {
    private static StoreServiceImpl service = StoreServiceImpl.getService();
    private static Store store = StoreFactory.createStore("Shoprite", "Woodstock", "Retail Store");

    @Test
    void a_create() {
        Store created = service.create(store);
        assertNotNull(created);
        System.out.println( "Created: " + created);
    }

    @Test
    void b_read() {

        Store read = service.read(store.getStoreId());
        assertNotNull(read);
        System.out.println( "Created: " + read);

    }

    @Test
    void d_delete() {
        boolean success = service.delete(store.getStoreId());
        assertTrue(success);
        System.out.println("Deleted: " + success);

    }
}