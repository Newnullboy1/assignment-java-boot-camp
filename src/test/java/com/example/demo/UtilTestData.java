package com.example.demo;

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
            product.setId(Double.toString(i));
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
}
