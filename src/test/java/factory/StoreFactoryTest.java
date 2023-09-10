/**
 * StoreFactoryTest.java
 * This is a test class for Store factory class
 * @author Asive Sibeko 219475296
 * 03 April 2023
 */

package factory;

import za.ac.cput.domain.Store;
import za.ac.cput.factory.StoreFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StoreFactoryTest {

    private Store store1;
    private Store store2;
    private Store store3;
    @BeforeEach
    void setUp() {
        store1 = new Store();
        store2 = new Store();
        store3 = store1;
    }
    @Test
    public void test(){
        Store store = StoreFactory.createStore( "Checkers", "Cape Town", "retail store");
        System.out.println(store.toString());
        assertNotNull(store);
    }

    @Test
    void testEquality(){
        assertEquals(store1,store3);
    }

    @Test
    void testIdentity(){
        assertSame(store1,store3);
    }
    @Test
    void testFail(){
        assertEquals(store1,store2);
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    void testTimeout() {
        System.out.println("Timeout has passed");
    }

    @Test
    //Test is disabled
    @Disabled("Disabled until bug #42 has been resolved")

    void testWillBeSkipped() {
    }

}