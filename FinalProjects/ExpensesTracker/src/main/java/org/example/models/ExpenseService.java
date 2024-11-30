// ExpenseService.java
package org.example.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseService {
    private Connection connection;

    public ExpenseService() {
        connect();
        createTableIfNotExists();
    }

    private void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:expense.db");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }


    private void createTableIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS expenses (id INTEGER PRIMARY KEY AUTOINCREMENT, category TEXT, amount REAL)";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Failed to create table.");
            e.printStackTrace();
        }
    }

    public void addExpense(Expense expense) {
        String sql = "INSERT INTO expenses (category, amount) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, expense.getCategory());
            statement.setDouble(2, expense.getAmount());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Failed to add expense.");
            e.printStackTrace();
        }
    }

    public List<Expense> getAllExpenses() {
        List<Expense> expenses = new ArrayList<>();
        String sql = "SELECT * FROM expenses";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String category = resultSet.getString("category");
                double amount = resultSet.getDouble("amount");
                expenses.add(new Expense(id, category, amount));
            }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve expenses.");
            e.printStackTrace();
        }
        return expenses;
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Failed to close the database connection.");
                e.printStackTrace();
            }
        }
    }
}
