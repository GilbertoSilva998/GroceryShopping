package za.ac.cput.repository;

/**
 * ITransactionReportRepository.java
 * @author: Gilberto Silva (218239300)
 * Date: 08 April 2023
 */

import za.ac.cput.domain.Transaction;

import java.util.Set;

public interface ITransactionRepository extends IRepository<Transaction, String>{
    public Set<Transaction> getAll();
}
