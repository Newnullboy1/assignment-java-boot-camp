package com.example.demo.product;

import com.example.demo.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> productNotFound(ProductNotFoundException e) {
        ErrorResponse response = new ErrorResponse();
        String message = "product id: " + e.getMessage() + " not found.";
        response.setError(message);
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductSearchNotFoundException.class)
    public ResponseEntity<ErrorResponse> productSearchNotFound(ProductSearchNotFoundException e) {
        ErrorResponse response = new ErrorResponse();
        String message = "product search word: " + e.getMessage() + " not found.";
        response.setError(message);
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


}
