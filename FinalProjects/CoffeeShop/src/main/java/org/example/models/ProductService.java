// ProductService.java
package org.example.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private Connection connection;

    public ProductService(Connection connection) {
        this.connection = connection;
    }

    public void addProduct(Product product) {
        String sql = "INSERT INTO products (name, price) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.executeUpdate();
            System.out.println("Product added successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to add product.");
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                products.add(new Product(id, name, price));
            }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve products.");
            e.printStackTrace();
        }
        return products;
    }
}
