package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Transaction;
import za.ac.cput.exception.TransactionNotFoundException;
import za.ac.cput.repository.ITransactionRepository;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@CrossOrigin("http://localhost:3000")
public class TransactionController {

    @Autowired
    private ITransactionRepository transactionRepository;

    @PostMapping("/transaction")
    Transaction newTransaction(@RequestBody Transaction newTransaction){
        return transactionRepository.save(newTransaction);
    }

    @GetMapping("/transactions")
    List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }

    @GetMapping("/transaction/{id}")
    Transaction getTransactionById(@PathVariable Long id){
        return transactionRepository.findById(String.valueOf(id))
                .orElseThrow(()->new TransactionNotFoundException(id));
    }

    @PutMapping("/transaction/{id}")
    Transaction updateTransaction(@RequestBody Transaction newTransaction, @PathVariable Long id){
        return transactionRepository.findById(String.valueOf(id))
                .map(transaction -> {
                    transaction.setDate_Of_Transaction(newTransaction.getDate_Of_Transaction());
                    transaction.setTransaction_Type(newTransaction.getTransaction_Type());
                    transaction.setAmount(newTransaction.getAmount());
                    transaction.setCurrency(newTransaction.getCurrency());
                    transaction.setStatus(newTransaction.getStatus());
                    return transactionRepository.save(transaction);
                }).orElseThrow(()->new TransactionNotFoundException(id));
    }

    @DeleteMapping("/transaction/{id}")
    String deleteTransaction(@PathVariable Long id){
        if (!transactionRepository.existsById(String.valueOf(id))){
            throw new TransactionNotFoundException(id);
        }
        transactionRepository.deleteById(String.valueOf(id));
        return "Transaction with id " +id+ " has been deleted successfully.";
    }
    

    /* @Autowired
    private TransactionService transactionService;

    @PostMapping("/create")
    public Transaction create(@RequestBody Transaction transaction) {
        return transactionService.create(transaction);
    }
    @GetMapping("/read/{id}")
    public Transaction read (@PathVariable String id){
        return transactionService.read(id);
    }

    @PostMapping("/update")
    public Transaction update (@RequestBody Transaction transaction){
        return transactionService.update(transaction);
    }

    @DeleteMapping ("delete/{id}")
    public boolean delete (@PathVariable String id) {
        return transactionService.delete(id);
    }

    @GetMapping({"/getall"})
    public List<Transaction> getall(){
        return transactionService.getAll();
    } */

}
