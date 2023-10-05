/**
 * OrderFactory.java
 * This is a factory class for order entity
 * @author Asive Sibeko 219475296
 * 03 October 2023
 */

package za.ac.cput.factory;

import za.ac.cput.domain.Orders;
import za.ac.cput.util.Helper;

public class OrderFactory {

    public static Orders createOrder(String orderNumber, String orderType, String orderDescription) {

        if (Helper.isNullorEmpty(orderNumber) || Helper.isNullorEmpty(orderType) || Helper.isNullorEmpty(orderDescription))
            return null;
        String orderId = Helper.generateId();
        Orders order = new Orders.Builder().setOrderId(orderId)
                .setOrderNumber(orderNumber)
                .setOrderType(orderType)
                .setOrderDescription(orderDescription)
                .build();
        return order;
    }

    public static Orders createOrder(Orders order) {
        return order;
    }
}
