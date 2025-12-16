package com.techlab.pedidosnow.service;

import com.techlab.pedidosnow.exceptions.ProductNotFoundException;
import com.techlab.pedidosnow.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductService {
    private final List<Product> products = new ArrayList<>();
    private int nextId = 1;

    public ProductService() {
    }

    public List<Product> listAll() {
        return List.copyOf(products);
    }

    public Product findById(int id) throws ProductNotFoundException {
        Optional<Product> op = products.stream().filter(p -> p.getId() == id).findFirst();
        return op.orElseThrow(() -> new ProductNotFoundException("Producto con id " + id + " no encontrado"));
    }

    public void removeById(int id) throws ProductNotFoundException {
        Product p = findById(id);
        products.remove(p);
    }
}
