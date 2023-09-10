package za.ac.cput.controller;

import za.ac.cput.domain.Store;
import za.ac.cput.factory.StoreFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.service.IStoreService;

import java.util.Set;

@RestController
@RequestMapping("/store")
public class StoreController {

        private IStoreService storeService;

        @Autowired
        @PostMapping("/create")
       public Store create(@RequestBody Store store){
            Store newStore = StoreFactory.createStore(store.getStoreName(), store.getStoreAddress(), store.getStoreDescription());
            return storeService.create(newStore);
        }
        @GetMapping("/read/{id}")
        Store read(@PathVariable String StoreId){
            return storeService.read(StoreId);
        }
        @PostMapping("/update")
        Store update(@RequestBody  Store store){
            return storeService.update(store);
        }

        @DeleteMapping("/delete/{id}")
        boolean delete(@PathVariable String StoreId){
            return storeService.delete(StoreId);
        }
        @GetMapping("/all")
        Set<Store> getAll(){
            return storeService.getAll();
        }

}
