package com.techlab.pedidosnow.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int id;
    private final LocalDateTime createdAt;
    private final List<OrderItem> items = new ArrayList<>();

    public Order(int id) {
        this.id = id;
        this.createdAt = LocalDateTime.now();
    }

    public int getId() { return id; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public List<OrderItem> getItems() { return List.copyOf(items); }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public double getTotal() {
        return items.stream().mapToDouble(OrderItem::getSubtotal).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Pedido #%d - %s\n", id, createdAt));
        for (OrderItem it : items) sb.append("  - ").append(it).append("\n");
        sb.append(String.format("Total: $%.2f", getTotal()));
        return sb.toString();
    }
}
