package com.ecomerce.ecommerce.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="order_items")

public class OrderItem {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
    /**
     * @ManyToOne signignifie que OrderItem est une entité qui a une relation many-to-one avec Product
     */

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    


    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false,updatable= false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

     // s'éxécute quand on crée une donnée
     @PrePersist 
     protected void onCreate() {
         this.createdAt = LocalDateTime.now();
         this.updatedAt = LocalDateTime.now();
     }
 
     // s'éxécute quand on modifie une donnée
     @PreUpdate
     protected void onUpdate() {
         this.updatedAt = LocalDateTime.now();
     }

}
