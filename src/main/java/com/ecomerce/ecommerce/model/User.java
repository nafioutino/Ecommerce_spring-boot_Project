package com.ecomerce.ecommerce.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String email;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}
