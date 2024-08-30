package com.ecomerce.ecommerce.model;

import java.time.LocalDateTime;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;
// import lombok.EqualsAndHashCode;
// import lombok.Getter;
// import lombok.RequiredArgsConstructor;
// import lombok.Setter;
// import lombok.ToString;
/* 
@Getter
 @Setter
 @ToString
 @EqualsAndHashCode
 @RequiredArgsConstructor
*/

@Builder
@Data  // générer getter setter toString hashcode et constructeurs
@Entity // signifier que c'est une entité c'est-à-dire une table
@NoArgsConstructor // constructeur par défaut construit un objet vide
@AllArgsConstructor // constructeur avec tous les attributs
@Table(name="users") // nom de la table
public class User {
    @Id // clé primaire c'est-à-dire que l'id est unique et qu'il est auto-incrémenté
    @GeneratedValue // pour que l'id soit auto-incrémenté
    private Long id;
    @Column(nullable=false, unique=true) // nullable=false signifie que l'attribut ne peut pas être null et  unique=true signifie que l'attribut est unique
    private String username;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false)
    private String password;

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
    
    @OneToMany(mappedBy="user") // user est le nom de la variable dans la classe Order
    private List<Order> orders ;
    /**
     * @OneToMany : une relation de type OneToMany signifie qu'un utilisateur peut avoir plusieurs commandes, mais une commande ne peut appartenir qu'à un seul utilisateur.
     */


}
