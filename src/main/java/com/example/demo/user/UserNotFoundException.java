package com.example.demo.user;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String id) {
        super(id);
    }
}
