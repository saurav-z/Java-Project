package OOP.OrderingSystem;

import OOP.OrderingSystem.models.Customer;
import OOP.OrderingSystem.models.Items;
import OOP.OrderingSystem.models.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {
    public static void main(String[] args) {
        // Creating 10 electronics items
        Items item1 = new Items("Laptop", 800, 2);
        Items item2 = new Items("Smartphone", 500, 3);
        Items item3 = new Items("Headphones", 100, 5);
        Items item4 = new Items("Tablet", 300, 1);
        Items item5 = new Items("Camera", 700, 2);
        Items item6 = new Items("Smartwatch", 150, 4);
        Items item7 = new Items("TV", 1000, 1);
        Items item8 = new Items("Gaming Console", 400, 2);
        Items item9 = new Items("Speaker System", 200, 3);
        Items item10 = new Items("Monitor", 250, 2);

        // Creating an order with 3 items
        List<Items> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        itemList1.add(item3);
        itemList1.add(item6);


        // Creating another order with 2 items
        List<Items> itemList2 = new ArrayList<>();
        itemList2.add(item2);
        itemList2.add(item8);


        // Creating a third order with 5 items
        List<Items> itemList3 = new ArrayList<>();
        itemList3.add(item4);
        itemList3.add(item5);
        itemList3.add(item7);
        itemList3.add(item9);
        itemList3.add(item10);



        // Creating customers
        Customer customer1 = new Customer("Sumit");
        Customer customer2 = new Customer("Prayash");
        Customer customer3 = new Customer("Hacke");



        Order order1 = new Order("Sumit", "2024-01-22", itemList1);
        customer1.addOrderToHistory(order1);

        Order order2 = new Order("Prayash", "2024-01-23", itemList2);
        customer2.addOrderToHistory(order2);

        Order order3 = new Order("Hacke", "2024-01-24", itemList3);
        customer3.addOrderToHistory(order3);

        // Providing options to the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Print Bill");
        System.out.println("2. View Order History");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Print Bill
                System.out.println("Generating Bill for " + customer1.getName());
                order1.generateBill();
                break;
            case 2:
                // View Order History
                System.out.print("Enter date to view order history (e.g., 2024-01-22): ");
                String inputDate = scanner.next();
                customer1.viewOrderHistory(inputDate);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

}
