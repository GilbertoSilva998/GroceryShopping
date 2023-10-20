/**
 * Delivery.java
 * This is a POJO class for Delivery entity
 *
 * @author Anathi Mhlom 220006695
 * 20 September 2023
 **/

package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Delivery implements Serializable {
    @Id
    private String deliveryId;
    private String deliveryAddress;
    private String deliveryDate;
    private String deliveredBy;
    private String deliveryDescription;
    private String deliveryType;

    public Delivery() {

    }

    public Delivery(Builder builder) {
        this.deliveryId = builder.deliveryId;
        this.deliveryAddress = builder.deliveryAddress;
        this.deliveryDate = builder.deliveryDate;
        this.deliveredBy = builder.deliveredBy;
        this.deliveryDescription = builder.deliveryDescription;
        this.deliveryType = builder.deliveryType;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveredBy() {
        return deliveredBy;
    }

    public void setDeliveredBy(String deliveredBy) {
        this.deliveredBy = deliveredBy;
    }

    public String getDeliveryDescription() {
        return deliveryDescription;
    }

    public void setDeliveryDescription(String deliveryDescription) {
        this.deliveryDescription = deliveryDescription;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return Objects.equals(deliveryId, delivery.deliveryId) && Objects.equals(deliveryAddress, delivery.deliveryAddress) && Objects.equals(deliveryDate, delivery.deliveryDate) && Objects.equals(deliveredBy, delivery.deliveredBy) && Objects.equals(deliveryDescription, delivery.deliveryDescription) && Objects.equals(deliveryType, delivery.deliveryType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryId, deliveryAddress, deliveryDate, deliveredBy, deliveryDescription, deliveryType);
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "deliveryId: " + deliveryId +
                "deliveryAddress: " + deliveryAddress + '\'' +
                "deliveryDate: " + deliveryDate + '\'' +
                "deliveredBy: " + deliveredBy + '\'' +
                "deliveryDescription: " + deliveryDescription + '\'' +
                "deliveryType: " + deliveryType + '\'' +
                "}";
    }

    public static class Builder {
        private String deliveryId;
        private String deliveryAddress;
        private String deliveryDate;
        private String deliveredBy;
        private String deliveryDescription;
        private String deliveryType;

        public Builder setDeliveryId(String deliveryId) {
            this.deliveryId = deliveryId;
            return this;
        }

        public Builder setDeliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        public Builder setDeliveryDate(String deliveryDate) {
            this.deliveryDate = deliveryDate;
            return this;
        }

        public Builder setDeliveryBy(String deliveredBy) {
            this.deliveredBy = deliveredBy;
            return this;
        }

        public Builder setDeliveryDescription(String deliveryDescription) {
            this.deliveryDescription = deliveryDescription;
            return this;
        }

        public Builder setDeliveryType(String deliveryType) {
            this.deliveryType = deliveryType;
            return this;
        }

        public Builder builder(Delivery delivery) {
            this.deliveryId = delivery.deliveryId;
            this.deliveryAddress = delivery.deliveryAddress;
            this.deliveryDate = delivery.deliveryDate;
            this.deliveredBy = delivery.deliveredBy;
            this.deliveryDescription = delivery.deliveryDescription;
            this.deliveryType = delivery.deliveryType;
            return this;
        }

        public Delivery build() {
            return new Delivery(this);
        }
    }
}