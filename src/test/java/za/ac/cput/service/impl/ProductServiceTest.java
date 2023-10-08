package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.ProductFactory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.service.impl.ProductService;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService service;
    private static final Product product = ProductFactory.createProduct(1, "Dairy", "Milk", "Fair Cape");

    @Test
    void a_create() {
        Product created = service.create(product);
        assert product != null;
        assertNotNull(created);
        System.out.println( "Created: " + created);
    }

    @Test
    void b_read() {
        Product read = service.read(product.getProductId());
        assert product != null;
        assertNotNull(read);
        System.out.println( "Created: " + read);

    }

    @Test
    @Disabled
    void d_delete() {
        boolean success = service.delete(product.getProductId());
        assertTrue(success);
        System.out.println("Deleted: " + success);

    }


}