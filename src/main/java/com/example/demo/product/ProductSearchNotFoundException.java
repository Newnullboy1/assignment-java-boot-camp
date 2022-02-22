package com.example.demo.product;

public class ProductSearchNotFoundException extends RuntimeException {
    public ProductSearchNotFoundException (String searchString) {
        super(searchString);
    }
}
