package za.ac.cput.service;

import za.ac.cput.domain.Driver;
import za.ac.cput.domain.Transaction;

import java.util.List;
import java.util.Set;

public interface ITransactionService extends IService<Transaction, String> {
     List<Transaction> getAll();
}
