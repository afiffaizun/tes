package com.techmafif.crud.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techmafif.crud.model.Product;
import com.techmafif.crud.service.ProductService;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
            Product product = productService.getProductById(id)
                .orElseThrow(
                    () -> new RuntimeException("Product not found"));
            return ResponseEntity.ok(product);
    }

    @GetMapping("/category/{categoryName}")
    public ResponseEntity<List<Product>> getProductsByCategory (
        @PathVariable String categoryName
    ) {
        return ResponseEntity.ok(productService.getProductByCategory(categoryName));
    }

    @GetMapping("/price/{maxPrice}")
    public ResponseEntity<List<Product>> getProductsByPriceLessThanEqual(
        @PathVariable Double maxPrice
    ) {
        return ResponseEntity.ok(productService.getProductByPriceLessThanEqual(maxPrice));
    }
    
}
