/**
 * Orders.java
 * This is a POJO class for Order entity
 *
 * @author Anathi Mhlom 220006695
 * 20 September 2023
 **/

package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Orders implements Serializable {
    @Id
    private String orderId;
    private String orderNumber;
    private String orderType;
    private String orderDescription;

    public Orders () {

    }

    public Orders (Builder builder) {
        this.orderId = builder.orderId;
        this.orderNumber = builder.orderNumber;
        this.orderType = builder.orderType;
        this.orderDescription = builder.orderDescription;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders order = (Orders) o;
        return Objects.equals(orderId, order.orderId) && Objects.equals(orderNumber, order.orderNumber) && Objects.equals(orderType, order.orderType) && Objects.equals(orderDescription, order.orderDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderNumber, orderType, orderDescription);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId: " + orderId +
                "orderNumber: " + orderNumber + '\'' +
                "orderType: " + orderType + '\'' +
                "orderDescription: " + orderDescription + '\'' +
                "}";
    }

    public static class Builder {
        private String orderId;
        private String orderNumber;
        private String orderType;
        private String orderDescription;

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setOrderNumber(String orderNumber) {
            this.orderNumber = orderNumber;
            return this;
        }

        public Builder setOrderType(String orderType) {
            this.orderType = orderType;
            return this;
        }

        public Builder setOrderDescription(String orderDescription) {
            this.orderDescription = orderDescription;
            return this;
        }

        public Builder builder(Orders order) {
            this.orderId = order.orderId;
            this.orderNumber = order.orderNumber;
            this.orderType = order.orderType;
            this.orderDescription = order.orderDescription;
            return this;
        }

        public Orders build() {
            return new Orders(this);
        }
    }
}