package com.ecomerce.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomerce.ecommerce.model.Product;
import com.ecomerce.ecommerce.services.ProductService;
;

@RestController 
@RequestMapping("/products")
public class ProductController {
     @Autowired
    private ProductService productService
    ;

    @GetMapping // indique que cette méthode répond aux requêtes HTTP GET
    public List<Product> getAllProducts() {
        return productService
        .getAllProducts();
    }

    @GetMapping("/{id}") // indique que cette méthode répond aux requêtes HTTP GET avec un paramètre id
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService
        .getProductById(id);
        return ResponseEntity.ok(product); // renvoie l'utilisateur correspondant à l'id fourni
    }

    @PostMapping // indique que cette méthode répond aux requêtes HTTP POST et crée un nouvel
                 // utilisateur
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product newProduct = productService
        .createProduct(product); // crée un nouvel utilisateur avec les données fournies
        return ResponseEntity.ok(newProduct); // renvoie le nouvel utilisateur créé
    }

    @PutMapping("/{id}") // indique que cette méthode répond aux requêtes HTTP PUT et met à jour un
                         // utilisateur existant
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product productToUpdate = productService
        .updateProduct(id, product); // met à jour l'utilisateur correspondant à l'id fourni avec les
        return ResponseEntity.ok(productToUpdate); // renvoie l'utilisateur mis à jour
    }

    @DeleteMapping("/{id}") // indique que cette méthode répond aux requêtes HTTP DELETE et supprime un
                            // utilisateur existant
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService
        .deleteProduct(id); // supprime l'utilisateur correspondant à l'id fourni
        return ResponseEntity.noContent().build(); // renvoie une réponse HTTP 204 No Content
    }

    /**
     * @ResponseEntity: indique que la méthode renverra une réponse HTTP avec un
     *                  code, c'est-à-dire que c'est une classe qui gère les
     *                  requêtes HTTP pour les ressources de l'utilisateur
     * @PathVariable: indique que l'id fourni dans l'URL sera utilisé pour
     *                identifier l'utilisateur à modifier
     * @RequestBody: indique que l'utilisateur fourni dans la requête HTTP sera
     *               utilisé pour modifier l'utilisateur existant c
     */
    
}
