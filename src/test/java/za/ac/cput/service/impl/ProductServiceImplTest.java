package za.ac.cput.service.impl;

import za.ac.cput.domain.Product;
import za.ac.cput.factory.ProductFactory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.service.impl.ProductServiceImpl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ProductServiceImplTest {
    private static ProductServiceImpl service = ProductServiceImpl.getService();
    private static Product product = ProductFactory.createProduct(1, "Dairy", "Milk", "Fair Cape");

    @Test
    void a_create() {
        Product created = service.create(product);
        assertNotNull(created);
        System.out.println( "Created: " + created);
    }

    @Test
    void b_read() {
        Product read = service.read(product.getProductId());
        assertNotNull(read);
        System.out.println( "Created: " + read);

    }

    @Test
    void d_delete() {
        boolean success = service.delete(product.getProductId());
        assertTrue(success);
        System.out.println("Deleted: " + success);

    }


}