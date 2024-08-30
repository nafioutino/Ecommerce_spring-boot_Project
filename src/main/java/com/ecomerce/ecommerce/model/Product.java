package com.ecomerce.ecommerce.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
@Table(name = "products")

public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "product")
    List<OrderItem> orderItems;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(name = "stock_quantity")
    private Integer stockQty;

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

    // un produit peut appartenir à plusieurs catégories
    @ManyToMany // indique qu'une relation many-to-many existe entre Product et Category
                // c'est-à-dire qu'un produit peut appartenir à plusieurs catégories et une
                // catégorie peut contenir plusieurs produits
    @JoinTable(name = "categories_products", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Category> categories;

    /**
     * @ManyToMany indique qu'une relation many-to-many existe entre Product et
     *             Category c'est-à-dire qu'un produit peut appartenir à plusieurs
     *             catégories et une catégorie peut contenir plusieurs produits
     *             joinTable indique que la relation many-to-many est matérialisée
     *             par une table de jointure nommée categories_products
     */

}
