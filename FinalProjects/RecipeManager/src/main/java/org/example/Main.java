package org.example;

import org.example.models.Category;
import org.example.models.Ingredient;
import org.example.models.Recipe;
import org.example.models.Tag;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String DB_URL = "jdbc:sqlite:recipe.db";

    public static void main(String[] args) {
        createTablesIfNotExist();
        start();
    }

    private static void createTablesIfNotExist() {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement()) {
            // Create tables if they don't exist
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS categories (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT UNIQUE)");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS ingredients (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT UNIQUE)");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS tags (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT UNIQUE)");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS recipes (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, instructions TEXT, category_id INTEGER, FOREIGN KEY(category_id) REFERENCES categories(id))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS recipe_ingredients (recipe_id INTEGER, ingredient_id INTEGER, FOREIGN KEY(recipe_id) REFERENCES recipes(id), FOREIGN KEY(ingredient_id) REFERENCES ingredients(id), PRIMARY KEY(recipe_id, ingredient_id))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS recipe_tags (recipe_id INTEGER, tag_id INTEGER, FOREIGN KEY(recipe_id) REFERENCES recipes(id), FOREIGN KEY(tag_id) REFERENCES tags(id), PRIMARY KEY(recipe_id, tag_id))");
            System.out.println("Tables created successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to create tables.");
            e.printStackTrace();
        }
    }

    private static void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("-------------------------");
            System.out.println("1. Add Recipe");
            System.out.println("2. View All Recipes");
            System.out.println("3. View Recipe Details");
            System.out.println("4. Search Recipe by Name");
            System.out.println("5. Add Category");
            System.out.println("6. Add Ingredient");
            System.out.println("7. Add Tag");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            System.out.println("-------------------------");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add Recipe
                    addRecipe(scanner);
                    break;
                case 2:
                    // View All Recipes
                    viewAllRecipes();
                    break;
                case 3:
                    // View Recipe Details
                    viewRecipeDetails(scanner);
                    break;
                case 4:
                    // Search Recipe by Name
                    searchRecipeByName(scanner);
                    break;
                case 5:
                    // Add Category
                    addCategory(scanner);
                    break;
                case 6:
                    // Add Ingredient
                    addIngredient(scanner);
                    break;
                case 7:
                    // Add Tag
                    addTag(scanner);
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

    private static void addRecipe(Scanner scanner) {
        System.out.println("-------------------------");
        System.out.print("Enter recipe name: ");
        String name = scanner.nextLine();
        System.out.print("Enter recipe instructions: ");
        String instructions = scanner.nextLine();
        System.out.print("Enter recipe category: ");
        String categoryName = scanner.nextLine();
        int categoryId = getOrCreateCategory(categoryName);
        System.out.println("Enter ingredients (type 'done' to finish):");
        List<Integer> ingredientIds = new ArrayList<>();
        String ingredientName;
        while (true) {
            System.out.print("Ingredient: ");
            ingredientName = scanner.nextLine();
            if (ingredientName.equals("done")) {
                break;
            }
            int ingredientId = getOrCreateIngredient(ingredientName);
            ingredientIds.add(ingredientId);
        }
        System.out.println("Enter tags (type 'done' to finish):");
        List<Integer> tagIds = new ArrayList<>();
        String tagName;
        while (true) {
            System.out.print("Tag: ");
            tagName = scanner.nextLine();
            if (tagName.equals("done")) {
                break;
            }
            int tagId = getOrCreateTag(tagName);
            tagIds.add(tagId);
        }
        int recipeId = addRecipeToDatabase(name, instructions, categoryId);
        addRecipeIngredientsToDatabase(recipeId, ingredientIds);
        addRecipeTagsToDatabase(recipeId, tagIds);
        System.out.println("Recipe added successfully.");
    }

    private static int getOrCreateCategory(String name) {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement("INSERT OR IGNORE INTO categories (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, name);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private static int getOrCreateIngredient(String name) {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement("INSERT OR IGNORE INTO ingredients (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, name);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private static int getOrCreateTag(String name) {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement("INSERT OR IGNORE INTO tags (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, name);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private static int addRecipeToDatabase(String name, String instructions, int categoryId) {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO recipes (name, instructions, category_id) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, name);
            statement.setString(2, instructions);
            statement.setInt(3, categoryId);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private static void addRecipeIngredientsToDatabase(int recipeId, List<Integer> ingredientIds) {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO recipe_ingredients (recipe_id, ingredient_id) VALUES (?, ?)")) {
            for (int ingredientId : ingredientIds) {
                statement.setInt(1, recipeId);
                statement.setInt(2, ingredientId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addRecipeTagsToDatabase(int recipeId, List<Integer> tagIds) {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO recipe_tags (recipe_id, tag_id) VALUES (?, ?)")) {
            for (int tagId : tagIds) {
                statement.setInt(1, recipeId);
                statement.setInt(2, tagId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static void viewAllRecipes() {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM recipes")) {
            if (!resultSet.isBeforeFirst()) {
                System.out.println("No recipes found.");
                return;
            }
            System.out.println("Recipes:");
            while (resultSet.next()) {
                System.out.println("Recipe ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Instructions: " + resultSet.getString("instructions"));
                System.out.println("Category ID: " + resultSet.getInt("category_id"));
                System.out.println("--------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void viewRecipeDetails(Scanner scanner) {
        System.out.print("Enter recipe ID to view details: ");
        int recipeId = scanner.nextInt();
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM recipes WHERE id = ?")) {
            statement.setInt(1, recipeId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (!resultSet.isBeforeFirst()) {
                    System.out.println("Recipe not found.");
                    return;
                }
                System.out.println("Recipe Details:");
                while (resultSet.next()) {
                    System.out.println("Recipe ID: " + resultSet.getInt("id"));
                    System.out.println("Name: " + resultSet.getString("name"));
                    System.out.println("Instructions: " + resultSet.getString("instructions"));
                    System.out.println("Category ID: " + resultSet.getInt("category_id"));
                    System.out.println("--------------------------------");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void searchRecipeByName(Scanner scanner) {
        System.out.print("Enter recipe name to search: ");
        String name = scanner.nextLine();
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM recipes WHERE name LIKE ?")) {
            statement.setString(1, "%" + name + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                if (!resultSet.isBeforeFirst()) {
                    System.out.println("Recipe not found.");
                    return;
                }
                System.out.println("Recipe(s) found:");
                while (resultSet.next()) {
                    System.out.println("- " + resultSet.getString("name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addCategory(Scanner scanner) {
        System.out.print("Enter category name: ");
        String name = scanner.nextLine();
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO categories (name) VALUES (?)")) {
            statement.setString(1, name);
            statement.executeUpdate();
            System.out.println("Category added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addIngredient(Scanner scanner) {
        System.out.print("Enter ingredient name: ");
        String name = scanner.nextLine();
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO ingredients (name) VALUES (?)")) {
            statement.setString(1, name);
            statement.executeUpdate();
            System.out.println("Ingredient added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addTag(Scanner scanner) {
        System.out.print("Enter tag name: ");
        String name = scanner.nextLine();
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO tags (name) VALUES (?)")) {
            statement.setString(1, name);
            statement.executeUpdate();
            System.out.println("Tag added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
