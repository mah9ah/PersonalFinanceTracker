package com.finance.tracker;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create an instance of the FinanceTracker
        FinanceTracker financeTracker = new FinanceTracker();

        // Set up a scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Simple user menu
        while (true) {
            System.out.println("\nPersonal Finance Tracker");
            System.out.println("1. Add a transaction");
            System.out.println("2. View all transactions");
            System.out.println("3. View total amount for a specific month-year");
            System.out.println("4. View total amount for all transactions");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine(); // Read the input as a String

            // Try to parse the input as an integer, and check for invalid input
            int choice;
            try {
                choice = Integer.parseInt(input); // Try converting the string to an integer
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 5.");
                continue; // Skip to the next iteration of the loop
            }

            // Switch case to handle different choices
            switch (choice) {
                case 1:
                    // Add a new transaction
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();

                    // Loop until the user enters a valid positive amount
                    BigDecimal amount;
                    while (true) {
                        System.out.print("Enter amount: ");
                        amount = new BigDecimal(scanner.nextLine());

                        if (amount.compareTo(BigDecimal.ZERO) < 0) {
                            System.out.println("Error: Sorry, you can't have a negative transaction amount.");
                        } else {
                            break; // Exit the loop if the amount is valid
                        }
                    }

                    // Get the month-year input (MM-YYYY format)
                    String monthYear = "";
                    while (true) {
                        System.out.print("Enter month-year (MM-YYYY): ");
                        monthYear = scanner.nextLine();

                        // Validate the month-year format (MM-YYYY)
                        if (monthYear.matches("\\d{2}-\\d{4}")) {
                            break; // Exit loop if format is valid
                        } else {
                            System.out.println("Invalid month-year format. Please use MM-YYYY.");
                        }
                    }

                    // Add the transaction
                    financeTracker.addTransaction(description, amount, monthYear);
                    break;

                case 2:
                    // View all transactions
                    System.out.println("Transactions:");
                    financeTracker.displayTransactions();
                    break;

                case 3:
                    // View total for a specific month-year (MM-YYYY)
                    System.out.print("Enter month-year (MM-YYYY) to view total: ");
                    String viewMonthYear = scanner.nextLine();

                    // Validate format MM-YYYY
                    if (viewMonthYear.matches("\\d{2}-\\d{4}")) {
                        BigDecimal total = financeTracker.getTotalForMonthYear(viewMonthYear);
                        System.out.println("Total for " + viewMonthYear + ": $" + total);
                    } else {
                        System.out.println("Invalid month-year format. Please use MM-YYYY.");
                    }
                    break;

                case 4:
                    // View the total amount of all transactions
                    System.out.println("Total amount for all transactions: $" + financeTracker.getTotalAmount());
                    break;

                case 5:
                    // Exit the program
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
