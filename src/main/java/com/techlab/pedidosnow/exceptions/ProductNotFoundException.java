package com.techlab.pedidosnow.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) { super(message); }
}
