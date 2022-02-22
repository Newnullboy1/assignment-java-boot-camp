package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    ProductService productService;

    @GetMapping("/product/search/{searchString}")
    public List<ProductEntity> searchProduct(@PathVariable String searchString) {
        return productService.searchProduct(searchString);
    }

    @GetMapping("/product/get/{id}")
    public ProductEntity getProductById(@PathVariable String id) {
        return productService.findById(id);
    }

}
