package com.example.demo.product;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String id) {
        super(id);
    }
}
