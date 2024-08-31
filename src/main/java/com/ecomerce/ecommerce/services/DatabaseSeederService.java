package com.ecomerce.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomerce.ecommerce.model.Order;
import com.ecomerce.ecommerce.model.OrderItem;
import com.ecomerce.ecommerce.model.Product;
import com.ecomerce.ecommerce.model.User;
import com.ecomerce.ecommerce.repositories.OrderItemRepository;
import com.ecomerce.ecommerce.repositories.OrderRepository;
import com.ecomerce.ecommerce.repositories.ProductRepository;
import com.ecomerce.ecommerce.repositories.UserRepository;
import com.github.javafaker.Faker;

@Service
public class DatabaseSeederService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository; // Ajouter le ProductRepository

    @Autowired
    OrderRepository orderRepository; // Ajouter le OrderRepository

    @Autowired
    OrderItemRepository orderItemRepository; // Ajouter le OrderItemRepository

    final Faker faker = new Faker();
    // Créer une liste d'OrderItem
    List<OrderItem> orderItems = new ArrayList<>();

    public void seedDatabase() {
        for (int i = 0; i < 10; i++) {

            User user = User.builder() // Supprimer 'new User()' avant 'builder()'
                    .email(faker.internet().emailAddress())
                    .username(faker.name().username())
                    .password(faker.internet().password())
                    .build();
            userRepository.save(user); // Sauvegarde les utilisateurs dans la base de données

            Product product = Product.builder() // Supprimer 'new Product()' avant 'builder()'
                    .name(faker.commerce().productName())
                    .description(faker.lorem().sentence()) // Utiliser faker.lorem() pour une description
                    .price(faker.commerce().price()) // Utiliser la méthode parsePrice
                    .stockQty(faker.number().numberBetween(1, 100))
                    .build();
            productRepository.save(product); // Sauvegarde les produits dans la base de données

            Order order = Order.builder()
                    .user(null)
                    .orderItems(null)
                    .totalAmount(faker.number().randomDouble(2, 1, 1000))
                    .status(faker.lorem().sentence())
                    .build();

            orderRepository.save(order); // Sauvegarde les commandes dans la base de données

            OrderItem orderItem = OrderItem.builder() // Supprimer 'new OrderItem()' avant 'builder()'
                    .order(null)
                    .product(null)
                    .price(faker.number().randomDouble(2, 1, 210))
                    .quantity(faker.number().numberBetween(1, 10))
                    .build();
            orderItemRepository.save(orderItem); // Sauvegarde les items de commande dans la base de données

        }
    }

    /**
     * Faker est une bibliothèque Java qui permet de générer des données
     * factices aléatoires. Pour l'utiliser, il faut l'ajouter à votre projet en
     * utilisant Maven ou Gradle. Ensuite, vous pouvez l'utiliser pour générer
     * des données factices pour vos tests ou pour remplir votre base de
     * données.
     *
     */
}
