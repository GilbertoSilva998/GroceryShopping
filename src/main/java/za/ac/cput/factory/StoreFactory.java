/**
 * StoreFactory.java
 * This is a factory class for store entity
 * @author Asive Sibeko 219475296
 * 03 April 2023
 */

package za.ac.cput.factory;

import za.ac.cput.domain.Store;
import za.ac.cput.util.Helper;

public class StoreFactory {

    public static Store createStore(String storeName, String storeAddress, String storeDescription) {

        if (Helper.isNullorEmpty(storeName) || Helper.isNullorEmpty(storeAddress) || Helper.isNullorEmpty(storeDescription))
            return null;
        String storeId = Helper.generateId();
        Store store = new Store.Builder().setStoreId(storeId)
                .setStoreName(storeName)
                .setStoreAddress(storeAddress)
                .setStoreDescription(storeDescription)
                .build();
        return store;
    }

    public static Store createStore(Store store) {
        return store;
    }
}