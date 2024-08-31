package com.ecomerce.ecommerce.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomerce.ecommerce.model.Order;
import com.ecomerce.ecommerce.repositories.OrderRepository;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Order non trouvé"));
        return order;
    }

    public Order createOrder(Order order) {
        Order newOrder = orderRepository.save(order);
        return newOrder;
    }

    public Order updateOrder(Long id, Order order) {
        Order orderToUpdate = orderRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Order avec l'id " + id + " non trouvé"));
        orderToUpdate.setTotalAmount(order.getTotalAmount());
        orderToUpdate.setStatus(order.getStatus());
        orderToUpdate.setUser(order.getUser());
        orderToUpdate.setOrderItems(order.getOrderItems());
        return orderToUpdate;
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

}
