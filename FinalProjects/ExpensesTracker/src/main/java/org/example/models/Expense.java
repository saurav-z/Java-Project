// Expense.java
package org.example.models;

public class Expense {
    private int id;
    private String category;
    private double amount;

    public Expense(int id, String category, double amount) {
        this.id = id;
        this.category = category;
        this.amount = amount;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
