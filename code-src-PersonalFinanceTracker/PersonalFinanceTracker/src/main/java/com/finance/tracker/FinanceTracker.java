package com.finance.tracker;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FinanceTracker {

    // A map to store transactions by month-year (MM-YYYY)
    private Map<String, BigDecimal> monthlyTotals = new HashMap<>();

    // Add a new transaction
    public void addTransaction(String description, BigDecimal amount, String monthYear) {
        // Print debug statement to show the extracted monthYear
        System.out.println("Adding transaction for: " + monthYear);

        // Update the total for this month-year combination
        BigDecimal newTotal = monthlyTotals.getOrDefault(monthYear, BigDecimal.ZERO).add(amount);
        monthlyTotals.put(monthYear, newTotal);

        // Print debug statement to show the updated total for that month-year
        System.out.println("Updated total for " + monthYear + ": $" + newTotal);

        System.out.println("Transaction added: " + description + " | Amount: $" + amount + " | Month-Year: " + monthYear);
    }

    // Display all transactions by month-year
    public void displayTransactions() {
        if (monthlyTotals.isEmpty()) {
            System.out.println("No transactions to display.");
        } else {
            for (Map.Entry<String, BigDecimal> entry : monthlyTotals.entrySet()) {
                String monthYear = entry.getKey();
                BigDecimal total = entry.getValue();
                System.out.println("Month-Year: " + monthYear + " | Total = $" + total);
            }
        }
    }

    // Get the total amount of all transactions (across all months and years)
    public BigDecimal getTotalAmount() {
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (BigDecimal monthTotal : monthlyTotals.values()) {
            totalAmount = totalAmount.add(monthTotal);
        }
        return totalAmount;
    }

    // Get the total for a specific month-year
    public BigDecimal getTotalForMonthYear(String monthYear) {
        return monthlyTotals.getOrDefault(monthYear, BigDecimal.ZERO);
    }
}
