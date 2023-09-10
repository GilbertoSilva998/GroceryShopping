package za.ac.cput.repository;

/**
 * IDriverService.java
 * @author: Gilberto Silva (218239300)
 * Date: 08 April 2023
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Driver;

import java.util.Set;

@Repository
public interface IDriverRepository extends JpaRepository<Driver, String> {

}
