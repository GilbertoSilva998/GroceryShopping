/**
 * CategoryfactoryTest.java
 * This is a test class for CategoryFactory
 * @author Sinentlahla Pindani 219081328
 * 08 April 2023
 */
package factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.domain.Category;
import za.ac.cput.factory.CategoryFactory;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
public class CategoryFactoryTest {
    private Category category1 ;
    private Category category2;
    private Category category3;

    @BeforeEach
    void setUp() {
        category1 = new Category() ;
        category2 = new Category() ;
        category3 = category1;

    }

    @Test
    public void test(){
        Category category = CategoryFactory.createCategory("Meat","Beef");
        System.out.println(category.toString());
        assertNotNull(category);
    }

    @Test
    void testEquality(){
        assertEquals(category1,category3);
    }

    @Test
    void testIdentity(){
        assertSame(category1,category3);
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
        assertEquals(category1, category2);
    }

}
