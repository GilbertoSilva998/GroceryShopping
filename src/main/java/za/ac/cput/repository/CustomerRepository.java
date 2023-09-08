/**
 * CustomerReposotory.java
 * This is a CustomerRepository class for Customer
 * @author Sinentlahla Pindani 219081328
 * 08 April 2023
 */
package za.ac.cput.repository;

import za.ac.cput.domain.Customer;

import java.util.HashSet;
import java.util.Set;

public class CustomerRepository implements ICustomerRepository{
    private static CustomerRepository repository = null;
    private Set<Customer> customerDB = null;
    private CustomerRepository(){
        customerDB = new HashSet<Customer>();
    }
    public static CustomerRepository getRepository(){
        if (repository == null){repository = new CustomerRepository();}
        return repository;
    }

    @Override
    public Customer create(Customer customer){
        boolean success = customerDB.add(customer);
        if (!success)
            return null;
        return customer;
    }

    @Override
    public Customer read(String customerId){
        Customer customer = customerDB.stream()
                .filter( e -> e.getCustomerId().equals(customerId))
                .findAny()
                .orElse(null);
        return customer;
    }
    @Override
    public Customer update(Customer customer) {
        Customer oldcustomer =read(customer.getCustomerId());
        if(oldcustomer != null) {
            customerDB.remove(oldcustomer);
            customerDB.add(customer);
            return customer;
        }
        return null;
    }

    @Override
    public boolean delete(String customerId){
        Customer customerToDelete = read(customerId);
        if(customerToDelete == null)
            return false;
        customerDB.remove(customerToDelete);

        return true;
    }

    @Override
    public Set<Customer> getAll(){
        return customerDB;
    }

}
