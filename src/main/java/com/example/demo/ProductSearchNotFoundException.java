package com.example.demo;

public class ProductSearchNotFoundException extends RuntimeException {
    public ProductSearchNotFoundException (String searchString) {
        super(searchString);
    }
}
