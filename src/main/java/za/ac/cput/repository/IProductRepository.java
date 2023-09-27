/**
 * IProductRepository.java
 * This is a repository interface for Product entity
 * @author Asive Sibeko 219475296
 * 08 April 2023
 */

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Product;

import java.util.Set;
@Repository
public interface IProductRepository extends JpaRepository<Product, String> {

}
