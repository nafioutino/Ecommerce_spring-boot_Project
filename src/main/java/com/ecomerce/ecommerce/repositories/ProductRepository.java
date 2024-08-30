package com.ecomerce.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomerce.ecommerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
