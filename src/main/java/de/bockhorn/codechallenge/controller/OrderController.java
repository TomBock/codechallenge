package de.bockhorn.codechallenge.controller;

import de.bockhorn.codechallenge.model.Order;
import de.bockhorn.codechallenge.model.Product;
import de.bockhorn.codechallenge.repository.ProductRepository;
import de.bockhorn.codechallenge.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Controller for all order related topics
 * Functions: post & get
 */
@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private EntityManager entityManager;

    /**
     * Maps the /post suburl to receive orders and
     * store the respective models in the database.
     * @param order Model of the order, which has been pre-mapped by Jackson to the java class.
     * @return Displayed result string.
     */
    @PostMapping(value = "/post")
    public ResponseEntity<HttpStatus> post(@RequestBody Order order) {

        // Order has to be passed to the products for mapping in the database
        order.getProducts().forEach(product -> product.setOrder(order));

        // Order and products stored in their respective tables
        orderRepository.save(order);
        productRepository.saveAll(order.getProducts());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Maps the /get suburl to present all order entries
     * that are stored in the database.
     * @return ResponseEntity containing of a list of orders and status.
     */
    @GetMapping("/get")
    public ResponseEntity<List<Order>> get() {
        return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
    }
}
