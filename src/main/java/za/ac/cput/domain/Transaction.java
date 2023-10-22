package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

/**
 * Transaction.java
 * @author: Gilberto Silva (218239300)
 * Date: 07 April 2023
 */

@Entity
public class Transaction implements Serializable {

    @Id
    private String transaction_ID;
    private String transaction_Type;

    private String date_Of_Transaction;
    private String amount;
    private String currency;
    private String status;


    //-------------Constructor----------------------
    protected Transaction() {}

    //---------------Builder----------------
    private Transaction(Builder builder){
        this.transaction_ID = builder.transaction_ID;
        this.transaction_Type = builder.transaction_Type;
        this.date_Of_Transaction = builder.date_Of_Transaction;
        this.amount = builder.amount;
        this.currency = builder.currency;
        this.status = builder.status;
    }

    //--------------Getters----------------------
    public String getTransaction_ID() {return transaction_ID;}

    public String getTransaction_Type() {return transaction_Type;}

    public String getDate_Of_Transaction() {return date_Of_Transaction;}

    public String getAmount() {return amount;}

    public String getCurrency() {return currency;}


    public String getStatus() {return status;}

    public void setTransaction_ID(String transaction_ID) {
        this.transaction_ID = transaction_ID;
    }

    public void setTransaction_Type(String transaction_Type) {
        this.transaction_Type = transaction_Type;
    }

    public void setDate_Of_Transaction(String date_Of_Transaction) {
        this.date_Of_Transaction = date_Of_Transaction;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //------------------Has Code -------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction that)) return false;
        return Objects.equals(getTransaction_ID(), that.getTransaction_ID()) && Objects.equals(getTransaction_Type(), that.getTransaction_Type()) && Objects.equals(getDate_Of_Transaction(), that.getDate_Of_Transaction()) && Objects.equals(getAmount(), that.getAmount()) && Objects.equals(getCurrency(), that.getCurrency()) && Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTransaction_ID(), getTransaction_Type(), getDate_Of_Transaction(), getAmount(), getCurrency(), getStatus());
    }


    //------------------To String-------------

    @Override
    public String toString() {
        return "Transaction{" +
                "transaction_ID=" + transaction_ID +
                ", transaction_Type='" + transaction_Type + '\'' +
                ", date_Of_Transaction=" + date_Of_Transaction +
                ", amount=" + amount +
                ", currency=" + currency +
                ", status='" + status + '\'' +
                '}';
    }


    //---------------Builder---------------------------
    public static class Builder{
        public String transaction_ID;
        public String transaction_Type;

        public String date_Of_Transaction;
        public String amount;
        public String currency;

        public String status;

        public Builder setTransaction(String transaction_ID){
            this.transaction_ID = transaction_ID;
            return this;
        }

        public Builder setTransaction_Type(String transaction_Type){
            this.transaction_Type = transaction_Type;
            return this;
        }


        public Builder setDate_Of_Transaction(String date_Of_Transaction){

            this.date_Of_Transaction = date_Of_Transaction;
            return this;
        }

        public Builder setAmount(String amount){

            this.amount = amount;
            return this;
        }


        public Builder setCurrency(String currency){

            this.currency = currency;
            return this;
        }

        public Builder setStatus(String status){
            this.status = status;
            return this;
        }

        public Builder copy(Transaction transaction) {
            this.transaction_ID = transaction.transaction_ID;
            this.transaction_Type = transaction.transaction_Type;
            this.date_Of_Transaction = transaction.date_Of_Transaction;
            this.amount = transaction.amount;
            this.currency = transaction.currency;
            this.status = transaction.status;

            return this;
        }

        public Transaction build(){

            return new Transaction(this);
        }

    }
}

