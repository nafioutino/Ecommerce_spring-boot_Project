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

import com.ecomerce.ecommerce.model.OrderItem;
import com.ecomerce.ecommerce.services.OrderItemService;

@RestController
@RequestMapping("/api/orderitems")
public class OrderItemController {
      @Autowired
    private OrderItemService orderItemService;

    @GetMapping // indique que cette méthode répond aux requêtes HTTP GET
    public List<OrderItem> getAllOrderitems() {
        return orderItemService.getAllOrderitems();
    }

    @GetMapping("/{id}") // indique que cette méthode répond aux requêtes HTTP GET avec un paramètre id
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Long id) {
        OrderItem orderItem = orderItemService.getOrderItemById(id);
        return ResponseEntity.ok(orderItem); // renvoie l'utilisateur correspondant à l'id fourni
    }

    @PostMapping // indique que cette méthode répond aux requêtes HTTP POST et crée un nouvel
                 // utilisateur
    public ResponseEntity<OrderItem> createUser(@RequestBody OrderItem orderItem) {
        OrderItem newOrderItem = orderItemService.createOrderItem(orderItem); // crée un nouvel utilisateur avec les données fournies
        return ResponseEntity.ok(newOrderItem); // renvoie le nouvel utilisateur créé
    }

    @PutMapping("/{id}") // indique que cette méthode répond aux requêtes HTTP PUT et met à jour un
                         // utilisateur existant
    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable Long id, @RequestBody OrderItem orderItem) {
        OrderItem orderItemToUpdate = orderItemService.updateOrderItem(id, orderItem); // met à jour l'utilisateur correspondant à l'id fourni avec les
        return ResponseEntity.ok(orderItemToUpdate); // renvoie l'utilisateur mis à jour
    }

    @DeleteMapping("/{id}") // indique que cette méthode répond aux requêtes HTTP DELETE et supprime un
                            // utilisateur existant
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
        orderItemService.deleteOrderItem(id); // supprime l'utilisateur correspondant à l'id fourni
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
