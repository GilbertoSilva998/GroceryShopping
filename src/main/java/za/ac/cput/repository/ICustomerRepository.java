/**
 * ICustomerRepository.java
 * This is a repository interface for Customer class
 * @author Sinentlahla Pindani 219081328
 * 08 April 2023
 */
package za.ac.cput.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String> {

}