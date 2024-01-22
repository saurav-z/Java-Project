package OOP.OrderingSystem.models;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Order> orderHistory;

    public Customer(String name) {
        this.name = name;
        this.orderHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public void addOrderToHistory(Order order) {
        orderHistory.add(order);
    }
    public void viewOrderHistory(String date) {
        System.out.println("Order History for " + name + " on " + date);
        System.out.println("----------------------------------------------");

        for (Order order : orderHistory) {
            if (order.getDate().equals(date)) {
                System.out.println("Order Date: " + order.getDate());
                System.out.printf("%-20s %-10s %-10s %-10s\n", "Item", "Price", "Quantity", "Total");
                System.out.println("----------------------------------------------");
                for (Items item : order.getItemList()) {
                    int itemTotal = item.getPrice() * item.getQuantity();
                    System.out.printf("%-20s $%-10d %-10d $%-10d\n", item.getName(), item.getPrice(), item.getQuantity(), itemTotal);
                }
                System.out.println("----------------------------------------------");

                return; // Stop searching after finding the order for the specified date
            }
        }

        System.out.println("No orders found for the specified date.");
    }
}
