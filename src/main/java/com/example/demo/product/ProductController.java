package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/search/{searchString}")
    public List<ProductEntity> searchProduct(@PathVariable String searchString) {
        return productService.searchProduct(searchString);
    }

    @GetMapping("/get/{id}")
    public ProductEntity getProductById(@PathVariable String id) {
        return productService.findById(id);
    }

}
