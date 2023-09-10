package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Transaction;
import za.ac.cput.repository.ITransactionRepository;
import za.ac.cput.service.ITransactionService;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {

    private ITransactionRepository repository;

    @Autowired
    private TransactionService(ITransactionRepository repository){
        this.repository = repository;
    }


    @Override
    public Transaction create(Transaction transaction) {return this.repository.save(transaction);}

    @Override
    public Transaction read(String transaction) {
        return this.repository.findById(transaction).orElse(null);
    }

    @Override
    public Transaction update(Transaction transaction) {
        if (this.repository.existsById(transaction.getTransaction_ID())) {
            return this.repository.save(transaction);
        }
        return null;
    }

    @Override
    public boolean delete(String transaction_ID) {
        if (this.repository.existsById(transaction_ID)) {
            this.repository.deleteById(transaction_ID);
            return true;
        }
        return false;
    }

    @Override
    public List<Transaction> getAll() {
        return this.repository.findAll();
    }
}
