package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Store;
import za.ac.cput.repository.IProductRepository;
import za.ac.cput.repository.IStoreRepository;
import za.ac.cput.service.IStoreService;

import java.util.Set;

public class StoreServiceImpl implements IStoreService {
    private static IStoreRepository repository;

    @Autowired
    private StoreServiceImpl(IStoreRepository repository){
        this.repository = repository;

    }

    public static StoreServiceImpl getService() {
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
