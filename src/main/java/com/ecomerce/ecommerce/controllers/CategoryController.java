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
import org.springframework.web.bind.annotation.RestController;

import com.ecomerce.ecommerce.model.User;
import com.ecomerce.ecommerce.repositories.UserRepository;

@RestController
public class CategoryController {
      @Autowired // indique que l'objet userRepository doit être injecté automatiquement par
               // Spring
    private UserRepository userRepository;

    @GetMapping // indique que cette méthode répond aux requêtes HTTP GET
    public List<User> getAllUsers() {
        return userRepository.findAll(); // renvoie tous les utilisateurs de la base de données
    }

    @GetMapping("/{id}") // indique que cette méthode répond aux requêtes HTTP GET avec un paramètre id
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow( // cherche l'utilisateur correspondant à l'id fourni
                () -> new RuntimeException("User non trouvé")); // renvoie une exception si l'utilisateur n'est pas
                                                                // trouvé
        return ResponseEntity.ok(user); // renvoie l'utilisateur correspondant à l'id fourni
    }

    @PostMapping // indique que cette méthode répond aux requêtes HTTP POST et crée un nouvel
                 // utilisateur
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userRepository.save(user); // sauvegarde l'utilisateur dans la base de données
        return ResponseEntity.ok(newUser); // renvoie le nouvel utilisateur créé
    }

    @PutMapping("/{id}") // indique que cette méthode répond aux requêtes HTTP PUT et met à jour un
                         // utilisateur existant
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User userToUpdate = userRepository
                .findById(id) // cherche l'utilisateur correspondant à l'id fourni
                .orElseThrow(() -> new RuntimeException("User avec l'id " + id + " non trouvé")); // renvoie une
                                                                                                  // exception si
                                                                                                  // l'utilisateur n'est
                                                                                                  // pas trouvé
        userToUpdate.setUsername(user.getUsername()); // met à jour le nom d'utilisateur
        userToUpdate.setEmail(user.getEmail()); // met à jour l'adresse e-mail
        userToUpdate.setPassword(user.getPassword()); // met à jour le mot de passe
        return ResponseEntity.ok(userToUpdate); // renvoie l'utilisateur mis à jour
    }

    @DeleteMapping("/{id}") // indique que cette méthode répond aux requêtes HTTP DELETE et supprime un
                            // utilisateur existant
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id); // supprime l'utilisateur correspondant à l'id fourni
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
