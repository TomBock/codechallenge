package de.bockhorn.codechallenge.service;

import de.bockhorn.codechallenge.model.Order;
import de.bockhorn.codechallenge.repository.OrderRepository;
import de.bockhorn.codechallenge.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer implementation that separates presentation and persistence.
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    /**
     * Saves the respective models in the database.
     * For 1:n relation within the database, the order has to be defined within the products first.
     * @param order Model of the order, which has been pre-mapped by Jackson to the java class
     */
    public void save(Order order) {
        // Order has to be passed to the products for mapping in the database
        order.getProducts().forEach(product -> product.setOrder(order));

        // Order and products stored in their respective tables
        orderRepository.save(order);
        productRepository.saveAll(order.getProducts());
    }

    /**
     * Loads all orders from the repository.
     * @return list of orders.
     */
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
