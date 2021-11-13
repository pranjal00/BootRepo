package com.actuator.controller;

import com.actuator.entities.Product;
import com.actuator.service.ProductService;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Timed(value = "product.time", description = "Time taken for process request")
    @GetMapping(value = "/allProducts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> showAllProducts() {
        return productService.getAllProduct();
    }

}
