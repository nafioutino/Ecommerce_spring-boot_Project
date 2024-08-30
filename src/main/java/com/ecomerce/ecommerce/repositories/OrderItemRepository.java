package com.ecomerce.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomerce.ecommerce.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    
}
