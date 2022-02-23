package com.example.demo.order;

import com.example.demo.UtilTestData;
import com.example.demo.product.ProductEntity;
import com.example.demo.product.ProductRepository;
import com.example.demo.product.ProductService;
import com.example.demo.user.UserEntity;
import com.example.demo.user.UserRepository;
import com.example.demo.user.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ProductRepository productRepository;

    private final UtilTestData utilTestData = new UtilTestData();

    @Test
    void create() {

        UserEntity user = utilTestData.generateUserMockData();
        when(userRepository.findById("0")).thenReturn(Optional.of(user));

        ProductEntity product = utilTestData.generateProductMockData().get(0);
        when(productRepository.findById("0")).thenReturn(Optional.of(product));

        OrderEntity order = utilTestData.generateOrderMockData();
        when(orderRepository.save(any(OrderEntity.class))).thenReturn(order);

        OrderCreateRequestModel newOrder = new OrderCreateRequestModel();
        newOrder.setPaymentMethod("Method0");
        newOrder.setProductId("0");
        newOrder.setUserId("0");

        UserService userService = new UserService();
        userService.setUserRepository(userRepository);

        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);

        OrderService orderService = new OrderService();
        orderService.setOrderRepository(orderRepository);
        orderService.setUserService(userService);
        orderService.setProductService(productService);

        OrderEntity result = orderService.create(newOrder);

        assertEquals(newOrder.getUserId(), result.getUser().getId());
        assertEquals(newOrder.getPaymentMethod(), result.getPaymentMethod());
        assertEquals(newOrder.getProductId(), result.getProduct().getId());

    }
}