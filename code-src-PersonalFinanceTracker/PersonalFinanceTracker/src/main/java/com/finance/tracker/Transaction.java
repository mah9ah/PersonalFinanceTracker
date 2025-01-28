package com.finance.tracker;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;

public class Transaction {
    private String description;
    private BigDecimal amount;
    private String date;

    // Constructor to initialize the transaction
    public Transaction(String description, BigDecimal amount, String date) {
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    // Getter and Setter methods
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // Overriding the toString() method to display formatted amount with a dollar sign
    @Override
    public String toString() {
        // Format amount with a dollar sign
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        String formattedAmount = currencyFormat.format(amount);
        return "Transaction{" +
                "description='" + description + '\'' +
                ", amount=" + formattedAmount +
                ", date='" + date + '\'' +
                '}';
    }
}
