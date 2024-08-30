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

import com.ecomerce.ecommerce.model.User;
import com.ecomerce.ecommerce.repositories.UserRepository;
import com.ecomerce.ecommerce.services.UserService;

@RestController // indique que cette classe est un contrôleur REST c'est-à-dire qu'elle gère les
                // requêtes HTTP
                // classe qui gère les requêtes HTTP
@RequestMapping("/users") // indique la route par défaut pour toutes les requêtes HTTP
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping // indique que cette méthode répond aux requêtes HTTP GET
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}") // indique que cette méthode répond aux requêtes HTTP GET avec un paramètre id
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user); // renvoie l'utilisateur correspondant à l'id fourni
    }

    @PostMapping // indique que cette méthode répond aux requêtes HTTP POST et crée un nouvel
                 // utilisateur
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.createUser(user); // crée un nouvel utilisateur avec les données fournies
        return ResponseEntity.ok(newUser); // renvoie le nouvel utilisateur créé
    }

    @PutMapping("/{id}") // indique que cette méthode répond aux requêtes HTTP PUT et met à jour un
                         // utilisateur existant
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User userToUpdate = userService.updateUser(id, user); // met à jour l'utilisateur correspondant à l'id fourni avec les
        return ResponseEntity.ok(userToUpdate); // renvoie l'utilisateur mis à jour
    }

    @DeleteMapping("/{id}") // indique que cette méthode répond aux requêtes HTTP DELETE et supprime un
                            // utilisateur existant
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id); // supprime l'utilisateur correspondant à l'id fourni
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
