package com.example.demo;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String id) {
        super(id);
    }
}
