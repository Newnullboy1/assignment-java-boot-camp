package com.example.demo.product;

import com.example.demo.UtilTestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private ProductService productService;

    private final UtilTestData utilTestData = new UtilTestData();

    @Test
    @DisplayName("ส่ง search string = nike แล้วจะได้รับการตอบกลับ product count = 3 ")
    void searchProduct() {

        List<ProductEntity> products = utilTestData.generateProductMockData();

        ProductListResponse productsResponse = new ProductListResponse();
        productsResponse.setProducts(products);

        when(productService.searchProduct("nike")).thenReturn(productsResponse);

        ProductListResponse result = testRestTemplate.getForObject("/product/search/nike", ProductListResponse.class);

        assertEquals(3,result.getProducts().size());

    }

    @Test
    @DisplayName("ส่ง product id = 0 จะได้รับการตอบกลับ product name = nike0")
    void getProductById() {

        List<ProductEntity> products = utilTestData.generateProductMockData();

        ProductEntity product = products.get(0);

        when(productService.getProductById("1")).thenReturn(product);

        ProductEntity result = testRestTemplate.getForObject("/product/get/1", ProductEntity.class);

        assertEquals("nike0",result.getName());

    }

}