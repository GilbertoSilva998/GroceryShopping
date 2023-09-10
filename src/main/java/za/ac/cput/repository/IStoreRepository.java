/**
 * StoreRepository.java
 * This is a repository interface for Store entity
 * @author Asive Sibeko 219475296
 * 08 April 2023
 */

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Store;

import java.util.Set;
@Repository
public interface IStoreRepository extends JpaRepository<Store, String> {

}
