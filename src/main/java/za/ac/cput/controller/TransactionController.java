package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Transaction;
import za.ac.cput.domain.Transaction;
import za.ac.cput.service.impl.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/transaction")
//@CrossOrigin("http://localhost:3000")
public class TransactionController {

    @Autowired
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
    }

}
