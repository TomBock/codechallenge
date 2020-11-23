package de.bockhorn.codechallenge.controller;

import de.bockhorn.codechallenge.model.Order;
import de.bockhorn.codechallenge.model.Product;
import de.bockhorn.codechallenge.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for all order related topics
 */
@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    /**
     * Maps the /post suburl to receive orders and
     * store the respective models in the database.
     * @param order Model of the order, which has been pre-mapped by Jackson ot the java class.
     * @return Displayed result string.
     */
    @PostMapping(value = "/post")
    public Order post(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    /**
     * Maps the /get suburl to present all order entries
     * that are stored in the database.
     * @return ResponseEntity containing of a list of orders and status.
     */
    @GetMapping("/get")
    public List<Order> get() {

        /*
        List<Order> orders = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        Product product1 = new Product("Produkt 1", 3);
        Product product2 = new Product("Produkt 2", 5);

        products.add(product1);
        products.add(product2);

        orders.add(new Order(1, products));
        */
        return orderRepository.findAll();
    }

}
