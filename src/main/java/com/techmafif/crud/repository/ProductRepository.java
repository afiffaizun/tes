package com.techmafif.crud.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.techmafif.crud.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
    List<Product> findProductByCategory(String name);
    List<Product> findProductByPriceLessThanEqual(Double maxprice);
    List<Product> findProductsByPriceLessThanEqual(Double price);
    List<Product> findProductsByNameContainingIgnoreCase(String name);
}
