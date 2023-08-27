import java.util.Scanner;

public class Billing_System {
    public static void main(String[] args) {
        int colddrink = 100, icecream = 200, momo = 350, pizza = 400, total = 0, item = 0, order = 0, total_items;
        Scanner scan = new Scanner(System.in);
        System.out.println("How many Items? ");
        total_items = scan.nextInt();

        int[] itemNumbers = new int[total_items];
        String[] itemNames = new String[total_items];
        int[] quantities = new int[total_items];
        double[] prices = new double[total_items];

        for (int i = 0; i < total_items; i++) {
            System.out.println("What do you like to order? ");
            System.out.println("1. Cold drink");
            System.out.println("2. Ice Cream");
            System.out.println("3. Momo");
            System.out.println("4. Pizza");
            System.out.println("Item Number: ");
            item = scan.nextInt();

            if (item == 1) {
                order = colddrink;
                itemNames[i] = "Cold Drink";
            } else if (item == 2) {
                order = icecream;
                itemNames[i] = "Ice Cream";
            } else if (item == 3) {
                order = momo;
                itemNames[i] = "Momo";
            } else if (item == 4) {
                order = pizza;
                itemNames[i] = "Pizza";
            } else {
                System.out.println("Item Not Found !");
                break;
            }

            itemNumbers[i] = item;

            System.out.println("Enter Quantity: ");
            int qty = scan.nextInt();
            quantities[i] = qty;
            prices[i] = order;

            total += (order * qty);
        }

        System.out.println("******Your Bill******");
        System.out.println("No of Items: " + total_items);

        for (int i = 0; i < total_items; i++) {
            System.out.println("Item Number: " + itemNumbers[i]);
            System.out.println("Item Name: " + itemNames[i]);
            System.out.println("Quantity: " + quantities[i]);
            System.out.println("Price per Item: $" + prices[i]);
            System.out.println("Subtotal: $" + (quantities[i] * prices[i]));
            System.out.println("------------------");
        }
        System.out.println("Total Bill: $" + total);

        scan.close();
    }
}