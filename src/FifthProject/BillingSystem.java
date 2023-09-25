package FifthProject;

import java.util.Scanner;

public class BillingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int itemCount = sc.nextInt();
        sc.nextLine();

        double totalCost = 0;

        for (int i = 1; i <= itemCount; i++) {
            System.out.print("Enter item name for item" + i + ": ");
            String itemName = sc.nextLine();
            System.out.print("Enter quantity for " + itemName + ": ");
            int itemQuantity = sc.nextInt();
            System.out.print("Enter price per item for " + itemName + ": ");
            double itemPrice = sc.nextDouble();

            double Total = itemQuantity * itemPrice;
            totalCost += Total;

            sc.nextLine();
        }

        double vat = totalCost * 0.13;
        double discount = totalCost * 0.10;
        double finalTotalCost = totalCost + vat - discount;

        System.out.println("-------- Bill --------");
        System.out.println("Total Cost: NRP" + totalCost);
        System.out.println("VAT (10%): NRP" + vat);
        System.out.println("Discount (10%): NRP" + discount);
        System.out.println("Final Total Cost: NRP" + finalTotalCost);

        sc.close();
    }
}

