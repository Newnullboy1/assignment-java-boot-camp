package com.example.demo.product;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Setter
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductListResponse searchProduct(String searchString) {

        ProductListResponse response = new ProductListResponse();

        String sqlString = "%".concat(searchString).concat("%");

        List<ProductEntity> products = productRepository.findByNameLike(sqlString);

        if (!products.isEmpty()) {
            response.setProducts(products);
            return response;
        }

        throw new ProductSearchNotFoundException(searchString);
    }

    public ProductEntity getProductById(String id) {

        Optional<ProductEntity> productOpt = productRepository.findById(id);

        if (productOpt.isPresent()) {
            return productOpt.get();
        }
        throw new ProductNotFoundException(id);
    }

}
