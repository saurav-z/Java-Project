package OOP.SecondTermExam;

import OOP.SecondTermExam.models.TShirt;
import OOP.SecondTermExam.models.Order;

import java.util.Arrays;
import java.util.Scanner;

public class TshirtStore {
    public static void main(String[] args) {
        System.out.println("----- Welcome to our store -----");
        Scanner sc = new Scanner(System.in);

        // Create T-shirt objects
        TShirt tshirt1 = new TShirt("Gorkhali Batman", 572, 1235.0, "Karuna", "You either die a hero or live long enough to see yourself be a villain", new String[]{"XL", "Medium", "Large"});
        TShirt tshirt2 = new TShirt("Nepal Flag", 573, 999.0, "Hacker", "Flag themed t-shirt", new String[]{"Small", "Medium", "Large"});
        TShirt tshirt3 = new TShirt("Adventure", 574, 1499.0, "Deerwalk", "Trending t-shirt", new String[]{"Medium", "Large", "Extra Large"});
        TShirt tshirt4 = new TShirt("Mountain", 575, 1299.0, "Explore", "Nature inspired design", new String[]{"Small", "Medium", "Large"});
        TShirt tshirt5 = new TShirt("Abstract Art", 576, 1599.0, "Artso", "Creative artwork", new String[]{"Medium", "Large", "Extra Large"});
        TShirt tshirt6 = new TShirt("Vintage Vibe", 577, 1199.0, "Vintage Vibes", "Classic vintage look", new String[]{"Small", "Medium", "Large"});

        System.out.println("**** Available T-Shirts: *****");
        tshirt1.displayTShirt();
        tshirt2.displayTShirt();
        tshirt3.displayTShirt();
        tshirt4.displayTShirt();
        tshirt5.displayTShirt();
        tshirt6.displayTShirt();

        // Create array of item codes
        System.out.print("Enter the item codes of the t-shirts separated by commas: ");
        String input = sc.nextLine();
        String[] itemCodesStr = input.split(",");
        int[] itemCodes = new int[itemCodesStr.length];
        for (int i = 0; i < itemCodesStr.length; i++) {
            itemCodes[i] = Integer.parseInt(itemCodesStr[i].trim());
        }

        // Create array of prices according to the item codes
        double[] prices = new double[itemCodes.length];
        for (int i = 0; i < itemCodes.length; i++) {
            switch (itemCodes[i]) {
                case 572:
                    prices[i] = tshirt1.getPrice();
                    break;
                case 573:
                    prices[i] = tshirt2.getPrice();
                    break;
                case 574:
                    prices[i] = tshirt3.getPrice();
                    break;
                case 575:
                    prices[i] = tshirt4.getPrice();
                    break;
                case 576:
                    prices[i] = tshirt5.getPrice();
                    break;
                case 577:
                    prices[i] = tshirt6.getPrice();
                    break;
                default:
                    System.out.println("Invalid item code: " + itemCodes[i]);
                    return;
            }
        }

        // Prompt for user input
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your phone number: ");
        String phoneNumber = sc.nextLine();

        // Create Order object with arrays of item codes and prices
        Order order1 = new Order(name, phoneNumber, itemCodes, prices);

        // Print the order details
        System.out.println("Order Details:");
        System.out.println("Name: " + name);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Items: " + Arrays.toString(itemCodes));
        System.out.println("Prices: " + Arrays.toString(prices));
    }
}
