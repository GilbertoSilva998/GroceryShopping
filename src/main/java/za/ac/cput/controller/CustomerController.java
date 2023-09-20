package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Customer;
import za.ac.cput.service.impl.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerservice;

    @PostMapping("/create")
    public Customer create(@RequestBody Customer customer){

        return customerservice.create(customer);
    }
    @GetMapping("/read/{id}")
    public Customer read(@PathVariable String id){
        return customerservice.read(id);
    }

    @PostMapping("/update")
    public Customer update(@RequestBody Customer customer){

        return customerservice.update(customer);
    }


    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return customerservice.delete(id);
    }


    @GetMapping("/getall")
    public List<Customer> getAll() {
        return  customerservice.getAll();
    }


}
