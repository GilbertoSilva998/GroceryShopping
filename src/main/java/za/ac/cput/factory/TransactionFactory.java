package za.ac.cput.factory;

/**
 * TransactionFactory.java
 * @author: Gilberto Silva (218239300)
 * Date: 08 April 2023
 */

import za.ac.cput.domain.Transaction;
import za.ac.cput.util.Helper;

public class TransactionFactory {
    public static Transaction createTransaction (String transaction_Type, String date_Of_Transaction, String amount, String currency, String status){
        if (Helper.isNullorEmpty(transaction_Type) || Helper.isNullorEmpty(status))
            return null;
        ;
        String transaction_ID = Helper.generateId();

        Transaction transaction = new Transaction.Builder().setTransaction(transaction_ID)
                .setTransaction_Type(transaction_Type)
                .setDate_Of_Transaction(date_Of_Transaction)
                .setAmount(amount)
                .setCurrency(currency)
                .setStatus(status)
                .build();
        return transaction;

    }
}
