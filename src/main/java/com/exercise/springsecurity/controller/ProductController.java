package com.exercise.springsecurity.controller;

import com.exercise.springsecurity.dto.Product;
import com.exercise.springsecurity.services.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public String welcome() {
        return "welcome!";
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    @GetMapping("/{productId}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Product getProduct(@PathVariable int productId) {
        return productService.getProduct(productId);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Product saveProduct(@PathVariable int id, @RequestBody Product product) {
        return productService.saveProduct(id, product);
    }

}
