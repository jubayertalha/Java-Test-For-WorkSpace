package Task2;

import java.time.LocalDateTime;

public class Transaction {
    public static enum TransactionType {
        DEBIT, CREDIT
    }

    private TransactionType type;
    private double amount;
    private double balance;
    private LocalDateTime transferDate;

    public Transaction(TransactionType type, double amount, double balance, LocalDateTime transferDate) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.transferDate = transferDate;
    }

    public void display() {

        System.out.println("\n***********************");
        System.out.println("\nTransaction type: " + type);
        System.out.println("Amount: " + amount);
        System.out.println("Balance: " + balance);
        System.out.println("Transfer date: " + transferDate);
        System.out.println();
        System.out.println("***********************\n");
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDateTime getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDateTime transferDate) {
        this.transferDate = transferDate;
    }
}
