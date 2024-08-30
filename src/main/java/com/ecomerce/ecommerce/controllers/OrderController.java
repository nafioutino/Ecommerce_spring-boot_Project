// package com.ecomerce.ecommerce.controllers;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.ecomerce.ecommerce.model.Order;
// import com.ecomerce.ecommerce.model.Product;
// import com.ecomerce.ecommerce.repositories.OrderRepository;
// import com.ecomerce.ecommerce.repositories.ProductRepository;

// @RestController
// @RequestMapping("/api/orders")
// public class OrderController {
//     @Autowired // indique que l'objet productRepository doit être injecté automatiquement par
//                // Spring
//     private OrderRepository orderRepository;

//     @GetMapping // indique que cette méthode répond aux requêtes HTTP GET
//     public List<Order> getAllOrders() {
//         return orderRepository.findAll(); // renvoie tous les utilisateurs de la base de données
//     }

//     @GetMapping("/{id}") // indique que cette méthode répond aux requêtes HTTP GET avec un paramètre id
//     public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
//         Order order = orderRepository.findById(id).orElseThrow( // cherche l'utilisateur correspondant à l'id fourni
//                 () -> new RuntimeException("Order non trouvé")); // renvoie une exception si l'utilisateur n'est pas
//                                                                  // trouvé
//         return ResponseEntity.ok(order); // renvoie l'utilisateur correspondant à l'id fourni
//     }

//     @PostMapping // indique que cette méthode répond aux requêtes HTTP POST et crée un nouvel
//                  // utilisateur
//     public ResponseEntity<Order> createOrder(@RequestBody Order order) {
//         Order newOrder = orderRepository.save(order); // sauvegarde l'utilisateur dans la base de données
//         return ResponseEntity.ok(newOrder); // renvoie l'utilisateur créé}
//     }

//     @PutMapping("/{id}") // indique que cette méthode répond aux requêtes HTTP PUT et met à jour un
//                          // utilisateur existant
//     public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
//         Order orderToUpdate = orderRepository
//                 .findById(id) // cherche l'utilisateur correspondant à l'id fourni
//                 .orElseThrow(() -> new RuntimeException("Order avec l'id " + id + " non trouvé")); // renvoie une
//                                                                                                    // exception si
//                                                                                                    // l'utilisateur
//                                                                                                    // n'est
//                                                                                                    // pas trouvé
//         orderToUpdate.setTotalAmount(order.getTotalAmount());
//         orderToUpdate.setStatus(order.getStatus());
//         orderToUpdate.setOrderItems(order.getOrderItems());
//         orderToUpdate.setUser(order.getUser());
//         return ResponseEntity.ok(orderRepository.save(orderToUpdate)); // sauvegarde les modifications et renvoie
//     }

//     @DeleteMapping("/{id}") // indique que cette méthode répond aux requêtes HTTP DELETE et supprime un
//                             // utilisateur existant
//     public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
//         orderRepository.deleteById(id); // supprime l'utilisateur correspondant à l'id fourni
//         return ResponseEntity.noContent().build(); // renvoie une réponse HTTP 204 No Content
//     }

//     /**
//      * @ResponseEntity: indique que la méthode renverra une réponse HTTP avec un
//      *                  code, c'est-à-dire que c'est une classe qui gère les
//      *                  requêtes HTTP pour les ressources de l'utilisateur
//      * @PathVariable: indique que l'id fourni dans l'URL sera utilisé pour
//      *                identifier l'utilisateur à modifier
//      * @RequestBody: indique que l'utilisateur fourni dans la requête HTTP sera
//      *               utilisé pour modifier l'utilisateur existant c
//      */

// }