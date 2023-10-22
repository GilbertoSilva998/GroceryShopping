package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Customer;
import za.ac.cput.exception.CustomerNotFoundException;
import za.ac.cput.repository.ICustomerRepository;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin("http://localhost:3000")
public class CustomerController {

    @Autowired
    private ICustomerRepository customerRepository;

    @PostMapping("/customer")
    Customer newCustomer(@RequestBody Customer newCustomer){
        return customerRepository.save(newCustomer);
    }

    @GetMapping("/customers")
    List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping("/customer/{id}")
    Customer getCustomerById(@PathVariable Long id){
        return customerRepository.findById(String.valueOf(id))
                .orElseThrow(()->new CustomerNotFoundException(id));
    }

    @PutMapping("/customer/{id}")
    Customer updateCustomer(@RequestBody Customer newCustomer, @PathVariable Long id){
        return customerRepository.findById(String.valueOf(id))
                .map(customer -> {
                    customer.setFirstName(newCustomer.getFirstName());
                    customer.setLastname(newCustomer.getLastName());
                    customer.setAddress(newCustomer.getAddress());
                    customer.setEmail(newCustomer.getEmail());
                    customer.setPhone(newCustomer.getPhone());
                    return customerRepository.save(customer);
                }).orElseThrow(()->new CustomerNotFoundException(id));
    }

    @DeleteMapping("/customer/{id}")
    String deleteCustomer(@PathVariable Long id){
        if (!customerRepository.existsById(String.valueOf(id))){
            throw new CustomerNotFoundException(id);
        }
        customerRepository.deleteById(String.valueOf(id));
        return "Customer with id " +id+ " has been deleted successfully.";
    }
    
    /* @Autowired
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
    } */


}
