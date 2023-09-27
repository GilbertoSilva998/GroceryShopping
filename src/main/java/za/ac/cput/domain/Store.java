/**
 * Store.java
 * This is a POJO class for store entity
 * @author Asive Sibeko 219475296
 * 03 April 2023
 */

package za.ac.cput.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Store {


    @Id
    private String storeId;
    private String storeName;
    private String storeAddress;
    private String storeDescription;

    public Store(){
    }

    private Store(Builder builder) {
        this.storeId = builder.storeId;
        this.storeName = builder.storeName;
        this.storeAddress = builder.storeAddress;
        this.storeDescription = builder.storeDescription;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStoreDescription() {
        return storeDescription;
    }

    public void setStoreDescription(String storeDescription) {
        this.storeDescription = storeDescription;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeId=" + storeId +
                ", storeName='" + storeName + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                ", storeDescription='" + storeDescription + '\'' +
                '}';
    }

    public static class Builder{
        private String storeId;
        private String storeName;
        private String storeAddress;
        private String storeDescription;

        public Builder setStoreId(String storeId) {
            this.storeId = storeId;
            return this;
        }

        public Builder setStoreName(String storeName) {
            this.storeName = storeName;
            return this;
        }

        public Builder setStoreAddress(String storeAddress) {
            this.storeAddress = storeAddress;
            return this;
        }

        public Builder setStoreDescription(String storeDescription) {
            this.storeDescription = storeDescription;
            return this;
        }

        public Builder copy(Store store){
            this.storeId = store.storeId;
            this.storeName = store.storeName;
            this.storeAddress = store.storeAddress;
            this.storeDescription =  store.storeDescription;
            return this;
        }
        public Store build(){
            return new Store(this);
        }
    }


}
