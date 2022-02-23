package com.example.demo.product;

import lombok.Data;

import java.util.List;

@Data
public class ProductListResponse {

    private List<ProductEntity> products;

}
