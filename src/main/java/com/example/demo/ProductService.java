package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<ProductEntity> searchProduct(String searchString) {

        String sqlString = "%".concat(searchString).concat("%");

        List<ProductEntity> products = productRepository.findByNameLike(sqlString);

        if (!products.isEmpty()) {
            return products;
        }

        throw new ProductSearchNotFoundException(searchString);
    }

    public ProductEntity findById(String id) {

        Optional<ProductEntity> productOpt = productRepository.findById(id);

        if (productOpt.isPresent()){
            return productOpt.get();
        }
        throw new ProductNotFoundException(id);
    }

}
