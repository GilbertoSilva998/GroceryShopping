/**
 * ICategoryRepository.java
 * This is a repository interface for Category class
 * @author Sinentlahla Pindani 219081328
 * 08 April 2023
 */
package za.ac.cput.repository;


import za.ac.cput.domain.Category;
import za.ac.cput.domain.Customer;

import java.util.Set;

public interface ICategoryRepository extends IRepository<Category, String>{
    public Set<Category> getAll();
}
