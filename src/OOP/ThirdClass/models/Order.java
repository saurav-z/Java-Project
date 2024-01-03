package OOP.ThirdClass.models;

import OOP.ThirdClass.models.Item;

import java.util.List;


public class Order {
    private int id;
    private List<Item> items;

    public Order(int id, List<Item> items) {
        this.id = id;
        this.items = items;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    // Custom function to calculate order total
    public double getOrderTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;

    }

}
