/**
 * IUserRepository.java
 * This is a Repository interface for User entity
 *
 * @author Anathi Mhlom 220006695
 * 08 April 2023
 */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.User;
@Repository
public interface IUserRepository extends JpaRepository<User, String> {
}