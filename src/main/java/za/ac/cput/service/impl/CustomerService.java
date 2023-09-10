package za.ac.cput.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.ICustomerRepository;
import za.ac.cput.service.ICustomerService;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    private ICustomerRepository repository;
    @Autowired
    private CustomerService(ICustomerRepository repository){
        this.repository=repository;

    }


    @Override
    public Customer create(Customer customer) {
        return this.repository.save(customer);
    }

    @Override
    public Customer read(String customerId) {
        return this.repository.findById(customerId).orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
        if( this.repository.existsById(customer.getCustomerId()))
            return this.repository.save(customer);
        return null;
    }

    @Override
    public boolean delete(String customerId) {
        if (this.repository.existsById(customerId)){
            this.repository.deleteById(customerId);
            return true;
        }
        return false;
    }
    @Override
    public List<Customer> getAll() {
        return this.repository.findAll();
    }



}
