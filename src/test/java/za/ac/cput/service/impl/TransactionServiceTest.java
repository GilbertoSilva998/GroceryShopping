package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Transaction;
import za.ac.cput.factory.TransactionFactory;
import za.ac.cput.service.ITransactionService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class TransactionServiceTest {

    @Autowired
    private TransactionService service;

    private static Transaction transaction = TransactionFactory.createTransaction("Cheque",
            "12/12/2022", "R1500", "Rands", "Sent");

    @Test
    void a_create() {
        Transaction created = service.create(transaction);
        assertEquals(transaction.getTransaction_ID(), created.getTransaction_ID());
        System.out.println("Created: " + created);

    }

    @Test
    void b_read() {
        Transaction read = service.read(transaction.getTransaction_ID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Transaction newTrans = new Transaction.Builder().copy(transaction).setTransaction_Type("Savings").build();
        Transaction updated = service.update(newTrans);
        assertEquals(newTrans.getTransaction_Type(), updated.getTransaction_Type());
        System.out.println("Updated: " + updated);

    }

    @Test
    @Disabled
    void e_delete() {
    }

    @Test
    void d_getAll() {
        List<Transaction> transactions = service.getAll();
        System.out.println("Get all: ");
        System.out.println(transactions);
    }
}