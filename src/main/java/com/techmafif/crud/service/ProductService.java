package com.techmafif.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.techmafif.crud.model.Product;
import com.techmafif.crud.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //getAll Prduct
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    //getProductById
    public Optional<Product> getProductByCategory(Long id) {
        return productRepository.findById(id);
    }

    //getProduct by Price
    public List<Product> getProductByPriceLessThanEqual(Double price) {
        return productRepository.findProductByPriceLessThanEqual(price);
    }

    //getProduct by name
    public List<Product> getProductByProductName(String name) {
        return productRepository.findProductsByNameContainingIgnoreCase(name);
    }

    //Save
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    //Delete
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }
 }
