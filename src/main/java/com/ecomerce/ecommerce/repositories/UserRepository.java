package com.ecomerce.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomerce.ecommerce.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
