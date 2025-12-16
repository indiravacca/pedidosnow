package com.techlab.pedidosnow.service;

import com.techlab.pedidosnow.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private final List<Order> orders = new ArrayList<>();
    private int nextId = 1;
    private final ProductService productService;

    public OrderService(ProductService ps) { this.productService = ps; }


    public List<Order> listOrders() { return List.copyOf(orders); }
}
