package za.ac.cput.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Store;
import za.ac.cput.repository.IStoreRepository;
import za.ac.cput.service.IStoreService;

import java.util.Set;
@Service
public class StoreService implements IStoreService {

    private IStoreRepository repository;

    @Autowired
    private StoreService(IStoreRepository repository){
        this.repository = repository;

    }

    public static StoreService getService() {
        return null;
    }


    @Override
    public Store create(Store store) {
        return this.repository.save(store);
    }

    @Override
    public Store read(String StoreId) {
        return this.repository.findById(StoreId).orElse(null);
    }

    @Override
    public Store update(Store store) {
        if (this.repository.existsById(store.getStoreId()))
            return this.repository.save(store);
        return null;
    }

    @Override
    public boolean delete(String storeId) {
        if (this.repository.existsById(storeId)){
            this.repository.deleteById(storeId);
            return true;

        }
        return false;
    }
    @Override
    public Set<Store> getAll() {

        return (Set<Store>) this.repository.findAll();
    }
}
