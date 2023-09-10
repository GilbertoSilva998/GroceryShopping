package za.ac.cput.repository;

/**
 * ITransactionReportRepository.java
 * @author: Gilberto Silva (218239300)
 * Date: 08 April 2023
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Transaction;

import java.util.Set;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction, String> {

}
