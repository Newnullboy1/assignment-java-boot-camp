package com.example.demo.order;

import lombok.Data;

@Data
public class OrderCreateRequestModel {

    private String userId;

    private String productId;

    private String paymentMethod;

}
