package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Store;
import za.ac.cput.exception.StoreNotFoundException;
import za.ac.cput.repository.IStoreRepository;

import java.util.List;

@RestController
@RequestMapping("/store")
@CrossOrigin("http://localhost:3000")
public class StoreController {

    @Autowired
    private IStoreRepository storeRepository;

    @PostMapping("/store")
    Store newStore(@RequestBody Store newStore){
        return storeRepository.save(newStore);
    }

    @GetMapping("/stores")
    List<Store> getAllStores(){
        return storeRepository.findAll();
    }

    @GetMapping("/store/{id}")
    Store getStoreById(@PathVariable Long id){
        return storeRepository.findById(String.valueOf(id))
                .orElseThrow(()->new StoreNotFoundException(id));
    }

    @PutMapping("/store/{id}")
    Store updateStore(@RequestBody Store newStore, @PathVariable Long id){
        return storeRepository.findById(String.valueOf(id))
                .map(store -> {
                    store.setStoreName(newStore.getStoreName());
                    store.setStoreAddress(newStore.getStoreAddress());
                    store.setStoreDescription(newStore.getStoreDescription());
                    return storeRepository.save(store);
                }).orElseThrow(()->new StoreNotFoundException(id));
    }

    @DeleteMapping("/store/{id}")
    String deleteStore(@PathVariable Long id){
        if (!storeRepository.existsById(String.valueOf(id))){
            throw new StoreNotFoundException(id);
        }
        storeRepository.deleteById(String.valueOf(id));
        return "Store with id " +id+ " has been deleted successfully.";
    }

    /** @Autowired
    private StoreService storeService;

    @PostMapping("/create")
    public Store create(@RequestBody Store store){

        return storeService.create(store);
    }
    @GetMapping("/read/{id}")
    public Store read(@PathVariable String storeId){
        return storeService.read(storeId);
    }

    @PostMapping("/update")
    public Store update(@RequestBody Store store){

        return storeService.update(store);
    }


    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String storeId){

        return storeService.delete(storeId);
    }


    @GetMapping("/getall")
    public List<Store> getAll() {

        return (List<Store>) storeService.getAll();
    } **/


}
