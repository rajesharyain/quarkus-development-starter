package org.codekafe.service;

import org.codekafe.model.Order;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class OrderService {

    @Inject
    EntityManager entityManager;

    @Transactional
    public List<Order> getAllOrders() {
        return entityManager.createQuery("SELECT o FROM Order o", Order.class).getResultList();
    }

    @Transactional
    public Order getOrderById(Long id) {
        return entityManager.find(Order.class, id);
    }

    @Transactional
    public Order createOrder(Order order) {
        if (order.getId() != null && entityManager.find(Order.class, order.getId()) != null) {
            return entityManager.merge(order);
        } else {
            entityManager.persist(order);
            return order;
        }
    }

    @Transactional
    public Order updateOrder(Long id, Order order) {
        Order existingOrder = entityManager.find(Order.class, id);
        if (existingOrder != null) {
            existingOrder.setUserId(order.getUserId());
            existingOrder.setProductId(order.getProductId());
            return entityManager.merge(existingOrder);
        }
        return null;
    }

    @Transactional
    public void deleteOrder(Long id) {
        Order order = entityManager.find(Order.class, id);
        if (order != null) {
            entityManager.remove(order);
        }
    }
}
