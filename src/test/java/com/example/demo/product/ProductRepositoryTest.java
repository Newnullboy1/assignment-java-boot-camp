package com.example.demo.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class ProductRepositoryTest {

    private final UtilTestData utilTestData = new UtilTestData();
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameLike_with_success() {
        List<ProductEntity> products = utilTestData.genProductMockData();
        productRepository.saveAll(products);

        List<ProductEntity> result = productRepository.findByNameLike("%nike%");

        assertEquals(3, result.size());

    }

}