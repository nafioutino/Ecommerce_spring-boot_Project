package com.ecomerce.ecommerce.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="orders") // pourque la table soit nommée orders
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne //pour dire que c'est une relation many to one
    @JoinColumn(name="user_id", nullable = true) // pour dire que c'est la colonne user_id qui fait la relation
    private User user; // vous pouvez avoir plusieurs commandes mais une commande ne peut avoir qu'un seul utilisateur

    @OneToMany(mappedBy = "order") // pour dire que c'est la colonne order qui fait la relation
    private List<OrderItem> orderItems;


    @Column(nullable = false)
    private Double totalAmount;

    @Column(nullable = false)
    private String status;

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
