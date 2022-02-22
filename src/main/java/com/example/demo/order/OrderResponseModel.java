package com.example.demo.order;

import lombok.Data;

@Data
public class OrderResponseModel {

    private String orderId;

    private String userName;

    private double totalPrice;
}
