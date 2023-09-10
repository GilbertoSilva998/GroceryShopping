package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Transaction;
import za.ac.cput.factory.TransactionFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class TransactionServiceTest {

    @Autowired
    private TransactionService service;

    private static Transaction transaction = TransactionFactory.createTransaction("Cheque",
            "12/12/2022","R1500","Rands","Sent");

    @Test
    void a_create() {


    }

    @Test
    void b_read() {

    }

    @Test
    void c_update() {
    }

    @Test
    void e_delete() {
    }

    @Test
    @Disabled
    void d_getAll() {
        System.out.println("Get all: ");
        System.out.println(service.getAll());
    }
}