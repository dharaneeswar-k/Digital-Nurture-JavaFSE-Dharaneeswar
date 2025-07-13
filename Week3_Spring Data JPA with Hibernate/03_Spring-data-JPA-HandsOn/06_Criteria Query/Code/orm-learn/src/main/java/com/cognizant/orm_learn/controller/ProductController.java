package com.cognizant.orm_learn.controller;

import com.cognizant.orm_learn.model.Product;
import com.cognizant.orm_learn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/search")
    public List<Product> search(@RequestBody Map<String, Object> filters) {
        return productService.searchProducts(filters);
    }
}