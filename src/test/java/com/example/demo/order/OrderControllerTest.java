package com.example.demo.order;

import com.example.demo.UtilTestData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private OrderService orderService;

    private final UtilTestData utilTestData = new UtilTestData();

    @Test
    void createOrder() {

        OrderEntity order = utilTestData.generateOrderMockData();

        OrderCreateRequestModel newOrder = new OrderCreateRequestModel();
        newOrder.setPaymentMethod("Method0");
        newOrder.setProductId("0");
        newOrder.setUserId("0");

        when(orderService.create(newOrder)).thenReturn(order);
        OrderEntity result = testRestTemplate.postForObject("/order/create", newOrder, OrderEntity.class);

        assertEquals(newOrder.getUserId(), result.getUser().getId());
        assertEquals(newOrder.getPaymentMethod(), result.getPaymentMethod());
        assertEquals(newOrder.getProductId(), result.getProduct().getId());

    }
}