/**
 * DeliveryFactory.java
 * This is a factory class for delivery entity
 * @author Asive Sibeko 219475296
 * 03 October 2023
 */

package za.ac.cput.factory;

import za.ac.cput.domain.Delivery;
import za.ac.cput.util.Helper;

import java.util.Date;

public class DeliveryFactory {

    public static Delivery createDelivery(String deliveryAddress, Date deliveryDate, String deliveredBy, String deliveryDescription, String deliveryType) {

        if (Helper.isNullorEmpty(deliveryAddress) || Helper.isNullorEmpty(String.valueOf(deliveryDate)) || Helper.isNullorEmpty(deliveredBy) || Helper.isNullorEmpty(deliveryDescription) || Helper.isNullorEmpty(deliveryType))
            return null;
        String deliveryId = Helper.generateId();
        Delivery delivery = new Delivery.Builder().setDeliveryId(deliveryId)
                .setDeliveryAddress(deliveryAddress)
                .setDeliveryDate(deliveryDate)
                .setDeliveryBy(deliveredBy)
                .setDeliveryDescription(deliveryId)
                .setDeliveryType(deliveryType)
                .build();
        return delivery;
    }

    public static Delivery createDelivery(Delivery delivery) {
        return delivery;
    }
}
