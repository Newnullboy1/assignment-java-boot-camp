package com.example.demo.product;

import com.example.demo.UtilTestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    private final UtilTestData utilTestData = new UtilTestData();

    @Mock
    private ProductRepository productRepository;

    @Test
    void searchProductSuccess() {

        List<ProductEntity> products = utilTestData.generateProductMockData();
        when(productRepository.findByNameLike("%nike%")).thenReturn(products);

        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        ProductListResponse result = productService.searchProduct("nike");

        assertEquals(3, result.getProducts().size());

    }

    @Test
    void getProductByIdSuccess() {

        ProductEntity product = utilTestData.generateProductMockData().get(0);
        when(productRepository.findById("0")).thenReturn(Optional.of(product));

        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        ProductEntity result = productService.getProductById("0");

        assertEquals("nike0", result.getName());
    }

}