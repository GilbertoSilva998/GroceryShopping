package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Store;
import za.ac.cput.service.impl.StoreService;

import java.util.List;

@RestController
@RequestMapping("/store")
//@CrossOrigin("http://localhost:3000")
public class StoreController {

    @Autowired
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
    }


}
