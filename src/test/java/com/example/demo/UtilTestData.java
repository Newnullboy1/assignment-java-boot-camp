package com.example.demo;

import com.example.demo.order.OrderEntity;
import com.example.demo.product.ProductEntity;
import com.example.demo.user.UserEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtilTestData {

    public List<ProductEntity> generateProductMockData() {
        List<ProductEntity> products = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            ProductEntity product = new ProductEntity();
            product.setId(Integer.toString(i));
            product.setDescription("DESC" + i);
            product.setName("nike" + i);
            product.setPrice(i*1000);
            product.setPhotoPath("/path"+i);
            products.add(product);
        }
        return products;
    }

    public UserEntity generateUserMockData() {

        UserEntity user = new UserEntity();
        user.setId("0");
        user.setName("User0");
        user.setAddress("Address0");

        return user;
    }

    public OrderEntity generateOrderMockData() {
        List<ProductEntity> products = generateProductMockData();
        ProductEntity product = products.get(0);
        UserEntity user = generateUserMockData();

        OrderEntity order = new OrderEntity();
        order.setPaymentMethod("Method0");
        order.setId("0");
        order.setUser(user);
        order.setProduct(product);
        order.setTotalPrice(product.getPrice());

        return order;
    }
}
