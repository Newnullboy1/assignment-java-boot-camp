package com.example.demo.order;

import com.example.demo.product.ProductEntity;
import com.example.demo.product.ProductService;
import com.example.demo.user.UserEntity;
import com.example.demo.user.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Setter
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    public OrderEntity create(OrderCreateRequestModel request) {
        OrderEntity order = new OrderEntity();
        UserEntity user = userService.getUserById(request.getUserId());
        ProductEntity product = productService.getProductById(request.getProductId());

        order.setProduct(product);
        order.setUser(user);
        order.setPaymentMethod(request.getPaymentMethod());

        return orderRepository.save(order);
    }
}
