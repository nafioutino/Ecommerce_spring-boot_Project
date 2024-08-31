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

import com.ecomerce.ecommerce.model.Order;
import com.ecomerce.ecommerce.services.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
     @Autowired
    private OrderService orderService;

    @GetMapping // indique que cette méthode répond aux requêtes HTTP GET
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}") // indique que cette méthode répond aux requêtes HTTP GET avec un paramètre id
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        return ResponseEntity.ok(order); // renvoie l'utilisateur correspondant à l'id fourni
    }

    @PostMapping // indique que cette méthode répond aux requêtes HTTP POST et crée un nouvel
                 // utilisateur
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order newOrder = orderService.createOrder(order); // crée un nouvel utilisateur avec les données fournies
        return ResponseEntity.ok(newOrder); // renvoie le nouvel utilisateur créé
    }

    @PutMapping("/{id}") // indique que cette méthode répond aux requêtes HTTP PUT et met à jour un
                         // utilisateur existant
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        Order orderToUpdate = orderService.updateOrder(id, order); // met à jour l'utilisateur correspondant à l'id fourni avec les
        return ResponseEntity.ok(orderToUpdate); // renvoie l'utilisateur mis à jour
    }

    @DeleteMapping("/{id}") // indique que cette méthode répond aux requêtes HTTP DELETE et supprime un
                            // utilisateur existant
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id); // supprime l'utilisateur correspondant à l'id fourni
        return ResponseEntity.noContent().build(); // renvoie une réponse HTTP 204 No Content
    }
}