/**
 * ICategoryRepository.java
 * This is a repository interface for Category class
 * @author Sinentlahla Pindani 219081328
 * 08 April 2023
 */
package za.ac.cput.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, String> {

}