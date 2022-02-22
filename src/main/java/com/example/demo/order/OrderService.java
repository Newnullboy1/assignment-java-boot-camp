package com.example.demo.order;

import com.example.demo.product.ProductEntity;
import com.example.demo.product.ProductService;
import com.example.demo.user.UserEntity;
import com.example.demo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    public OrderResponseModel create(OrderCreateRequestModel request) {
        OrderEntity order = new OrderEntity();
        OrderResponseModel response = new OrderResponseModel();
        UserEntity user = userService.getUserById(request.getUserId());
        ProductEntity product = productService.getProductById(request.getProductId());

        order.setProduct(product);
        order.setUser(user);
        order.setPaymentMethod(request.getPaymentMethod());

        OrderEntity newOrder = orderRepository.save(order);

        response.setOrderId(newOrder.getId());
        response.setTotalPrice(newOrder.getProduct().getPrice());
        response.setUserName(newOrder.getUser().getName());

        return response;
    }
}
