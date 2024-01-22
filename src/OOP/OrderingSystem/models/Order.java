package OOP.OrderingSystem.models;

import java.util.List;
import java.util.Scanner;

public class Order {
    private String name;
    private String date;
    private List<Items> itemList;

    public Order(String name, String date, List<Items> itemList) {
        this.name = name;
        this.date = date;
        this.itemList = itemList;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public List<Items> getItemList() {
        return itemList;
    }

    public void generateBill() {
        int totalAmount = 0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Discount Percentage on Total Amount: ");
        double discount=sc.nextDouble();
        System.out.println("Order Bill for " + name + " - Date: " + date);
        System.out.println("----------------------------------------------");
        System.out.printf("%-20s %-10s %-10s %-10s\n", "Item", "Price", "Quantity", "Total");
        System.out.println("----------------------------------------------");

        for (Items item : itemList) {
            int itemTotal = item.getPrice() * item.getQuantity();
            totalAmount += itemTotal;

            System.out.printf("%-20s $%-10d %-10d $%-10d\n", item.getName(), item.getPrice(), item.getQuantity(), itemTotal);
        }

        System.out.println("----------------------------------------------");
        double discountAmount = (discount / 100) * totalAmount;
        double finalAmount = totalAmount - discountAmount;

        System.out.printf("%-40s $%-10d\n", "Total Amount", totalAmount);
        System.out.printf("%-40s $%-10.2f\n", "Discount Amount", discountAmount);
        System.out.printf("%-40s $%-10.2f\n", "Final Amount", finalAmount);
        System.out.println("----------------------------------------------");
    }
}
