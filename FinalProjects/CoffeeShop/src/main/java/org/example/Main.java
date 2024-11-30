// Main.java
package org.example;

import org.example.models.Product;
import org.example.models.ProductService;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String DB_URL = "jdbc:sqlite:coffee_shop.db";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            createTablesIfNotExist(connection);
            ProductService productService = new ProductService(connection);

            // Start the application
            start(productService);
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }

    private static void createTablesIfNotExist(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS products (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT UNIQUE, price REAL)");
            System.out.println("Tables created successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to create tables.");
            e.printStackTrace();
        }
    }

    private static void start(ProductService productService) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("-------------------------");
            System.out.println("1. Add Product");
            System.out.println("2. View Menu");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            System.out.println("-------------------------");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add Product
                    addProduct(scanner, productService);
                    break;
                case 2:
                    // View Menu
                    viewMenu(productService);
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

    private static void addProduct(Scanner scanner, ProductService productService) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        Product product = new Product(0, name, price);
        productService.addProduct(product);
    }

    private static void viewMenu(ProductService productService) {
        System.out.println("Menu:");
        productService.getAllProducts().forEach(product ->
                System.out.println("ID: " + product.getId() + ", Name: " + product.getName() + ", Price: " + product.getPrice()));
    }
}
