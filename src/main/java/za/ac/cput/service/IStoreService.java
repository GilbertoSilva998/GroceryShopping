package za.ac.cput.service;

import za.ac.cput.domain.Store;

import java.util.Set;

public interface IStoreService extends IService<Store, String>{
    Set<Store> getAll();


}
