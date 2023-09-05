package za.ac.cput.repository;

/**
 * TransactionReportRepository.java
 * @author: Gilberto Silva (218239300)
 * Date: 08 April 2023
 */

import za.ac.cput.domain.Transaction;

import java.util.HashSet;
import java.util.Set;

public class TransactionRepository implements ITransactionRepository{
    private static TransactionRepository trRepository = null;
    private Set<Transaction> trSet = null;

    private TransactionRepository (){trSet = new HashSet<Transaction>();}

    public static TransactionRepository getRepository(){
        if (trRepository == null){
            trRepository = new TransactionRepository();
        }
        return trRepository;
    }

    @Override
    public Transaction create(Transaction transaction) {
        boolean success = trSet.add(transaction);
        if (!success)
            return null;
        return transaction;
    }

    @Override
    public Transaction read(String transaction_ID) {
        Transaction transaction = trSet.stream()
                .filter(s -> s.getTransaction_ID().equals(transaction_ID))
                .findAny()
                .orElse(null);
        return transaction;
    }

    @Override
    public Transaction update(Transaction transaction) {
        Transaction oldTransaction = read(transaction.getTransaction_ID());
        if (oldTransaction != null){
            trSet.remove(oldTransaction);
            trSet.add(transaction);
            return transaction;
        }
        return null;
    }

    @Override
    public boolean delete(String transaction_ID) {
        Transaction deleteTransaction = read(transaction_ID);
        if (deleteTransaction == null)
            return false;
        trSet.remove(deleteTransaction);
        return true;
    }

    @Override
    public Set<Transaction> getAll() {
        return trSet;
    }
}
