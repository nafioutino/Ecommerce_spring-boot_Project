package com.ecomerce.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomerce.ecommerce.model.OrderItem;
import com.ecomerce.ecommerce.repositories.OrderItemRepository;

@Service
public class OrderItemService {
      @Autowired
    OrderItemRepository orderItemRepository;

    public List<OrderItem> getAllOrderitems() {
        return orderItemRepository.findAll();
    }

    public OrderItem getOrderItemById(Long id) {
        OrderItem orderItem = orderItemRepository.findById(id).orElseThrow(
                () -> new RuntimeException("OrderItem non trouvé"));
        return orderItem;
    }

    public OrderItem createOrderItem(OrderItem orderItem) {
        OrderItem newOrderItem = orderItemRepository.save(orderItem);
        return newOrderItem;
    }

    public OrderItem updateOrderItem(Long id, OrderItem orderItem) {
        OrderItem orderItemToUpdate = orderItemRepository
                .findById(id) // cherche l'utilisateur correspondant à l'id fourni
                .orElseThrow(() -> new RuntimeException("OrderItem avec l'id " + id + " non trouvé")); // renvoie une
                                                                                                  // exception si
                                                                                                  // l'utilisateur n'est
                                                                                                  // pas trouvé
        orderItemToUpdate.setProduct(orderItem.getProduct());
        orderItemToUpdate.setPrice(orderItem.getPrice());
        orderItemToUpdate.setQuantity(orderItem.getQuantity());
        return orderItemToUpdate;
    }

    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id); // supprime l'utilisateur correspondant à l'id fourni
    }
    
}
