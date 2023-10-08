package factory;

import za.ac.cput.domain.Delivery;
import za.ac.cput.factory.DeliveryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DeliveryFactoryTest {
    private Delivery delivery1;
    private Delivery delivery2;
    private Delivery delivery3;
    @BeforeEach
    void setUp() {
        delivery1 = new Delivery();
        delivery2 = new Delivery();
        delivery3 = delivery1;
    }
    Date deliveryDate = new Date();
    @Test
    public void test(){
        Delivery delivery = DeliveryFactory.createDelivery("Salt River", deliveryDate, "Mike Stores", "Deliver to Salt River","Same day delivery" );
        System.out.println(delivery.toString());
        assertNotNull(delivery);
    }

    @Test
    void testEquality(){
        assertEquals(delivery1,delivery3);
    }

    @Test
    void testIdentity(){
        assertSame(delivery1,delivery3);
    }
    @Test
    void testFail(){
        assertEquals(delivery1,delivery2);
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    void testTimeout() {
        System.out.println("Timeout has passed");
    }

    @Test
    @Disabled("Disabled until bug #42 has been resolved")

    void testWillBeSkipped() {
    }

}