package factory;

import za.ac.cput.domain.Orders;
import za.ac.cput.factory.OrderFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderFactoryTest {
    private Orders order1;
    private Orders order2;
    private Orders order3;
    @BeforeEach
    void setUp() {
        order1 = new Orders();
        order2 = new Orders();
        order3 = order1;
    }
    @Test
    public void test(){
        Orders order = OrderFactory.createOrder("12", "written order", "Order sent by the buyer to the seller" );
        System.out.println(order.toString());
        assertNotNull(order);
    }

    @Test
    void testEquality(){
        assertEquals(order1,order3);
    }

    @Test
    void testIdentity(){
        assertSame(order1,order3);
    }
    @Test
    void testFail(){
        assertEquals(order1,order2);
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