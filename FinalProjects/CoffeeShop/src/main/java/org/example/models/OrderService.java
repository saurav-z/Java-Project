// OrderService.java
package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private List<Order> orders;

    public OrderService(List<Order> orders) {
        this.orders = orders;
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }
}
