package com.ecomerce.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomerce.ecommerce.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
