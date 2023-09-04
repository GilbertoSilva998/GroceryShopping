package domain;

/**
 * Transaction.java
 * @author: Gilberto Silva (218239300)
 * Date: 07 April 2023
 */
public class Transaction {
    public String transaction_ID;
    public String transaction_Type;

    public String date_Of_Transaction;
    public double amount;
    public String currency;

    public String status;

    //-------------Constructor----------------------
    public Transaction() {}

    //---------------Builder----------------
    private Transaction(Builder builder){
        this.transaction_ID = builder.transaction_ID;
        this.transaction_Type = builder.transaction_Type;
        this.date_Of_Transaction = builder.date_Of_Transaction;
        this.amount = builder.amount;
        this.currency = builder.currency;
    }

    //--------------Getters----------------------
    public String getTransaction_ID() {return transaction_ID;}

    public String getTransaction_Type() {return transaction_Type;}

    public String getDate_Of_Transaction() {return date_Of_Transaction;}

    public double getAmount() {return amount;}

    public String getCurrency() {return currency;}


    public String getStatus() {return status;}

    //------------------Setters-------------------------
    public void setTransaction_ID(String transaction_ID) {this.transaction_ID = transaction_ID;}

    public void setTransaction_Type(String transaction_Type) {this.transaction_Type = transaction_Type;}

    public void setDate_Of_Transaction(String date_Of_Transaction) {this.date_Of_Transaction = date_Of_Transaction;}

    public void setAmount(double amount) {this.amount = amount;}

    public void setCurrency(String currency) {this.currency = currency;}

    public void setStatus(String status) {this.status = status;}

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
        public double amount;
        public String currency;

        public String status;

        public Builder setTransactionReport(String transactionReport_ID){
            this.transaction_ID = transactionReport_ID;
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


        public Builder setAmount(double amount){

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

