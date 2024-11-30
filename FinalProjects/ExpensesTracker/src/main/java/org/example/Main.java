// Main.java
package org.example;

import org.example.models.Expense;
import org.example.models.ExpenseService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseService expenseService = new ExpenseService();

        // Start the application
        start(expenseService);
    }

    private static void start(ExpenseService expenseService) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("-------------------------");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            System.out.println("-------------------------");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add Expense
                    addExpense(scanner, expenseService);
                    break;
                case 2:
                    // View Expenses
                    viewExpenses(expenseService);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        scanner.close();
    }

    private static void addExpense(Scanner scanner, ExpenseService expenseService) {
        System.out.print("Enter expense category: ");
        String category = scanner.nextLine();
        System.out.print("Enter expense amount: ");
        double amount = scanner.nextDouble();
        Expense expense = new Expense(0, category, amount);
        expenseService.addExpense(expense);
    }

    private static void viewExpenses(ExpenseService expenseService) {
        System.out.println("Expenses:");
        expenseService.getAllExpenses().forEach(expense ->
                System.out.println("ID: " + expense.getId() + ", Category: " + expense.getCategory() + ", Amount: " + expense.getAmount()));
    }
}
