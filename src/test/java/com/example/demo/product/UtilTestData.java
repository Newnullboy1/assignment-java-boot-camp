package com.example.demo.product;

import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtilTestData {

    public List<ProductEntity> genProductMockData() {
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

}
