package OOP.ThirdClass;
import OOP.ThirdClass.models.Item;
import OOP.ThirdClass.models.Order;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create three items
        Item item1 = new Item(1, "Shoes", 100);
        Item item2 = new Item(2, "Hat", 50);
        Item item3 = new Item(3, "Pant", 200);
        Item item4= new Item(4,"Shirt",600);

        // Create three orders containing three items each
        List<Item> items1 = new ArrayList<>();
        items1.add(item1);
        items1.add(item2);
        items1.add(item3);
        Order order1 = new Order(1, items1);

        List<Item> items2 = new ArrayList<>();
        items2.add(item4);
        items2.add(item3);
        items2.add(item1);
        Order order2 = new Order(2, items2);

        List<Item> items3 = new ArrayList<>();
        items3.add(item3);
        items3.add(item1);
        items3.add(item1);
        Order order3 = new Order(3, items3);

        // Display order totals
        System.out.println("Order 1 Total: NRS" + order1.getOrderTotal());
        System.out.println("Order 2 Total: NRS" + order2.getOrderTotal());
        System.out.println("Order 3 Total: NRS" + order3.getOrderTotal());
    }
}
