package Task2;

import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transactions;

    public Account(double balance) {
        this.balance = balance;
        this.transactions = new ArrayList<Transaction>();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public boolean addTransaction(Transaction transaction) {
        try{
            if (transaction.getType() == Transaction.TransactionType.CREDIT) {
                this.balance += transaction.getAmount();
            } else if (transaction.getType() == Transaction.TransactionType.DEBIT) {
                if (this.balance >= transaction.getAmount()) {
                    this.balance -= transaction.getAmount();
                } else {
                    throw new Exception();
                }
            }
            this.transactions.add(transaction);
        }catch(Exception e){
            return false;
        }
        return true;
    }
}
