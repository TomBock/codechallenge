package de.bockhorn.codechallenge.controller;

import de.bockhorn.codechallenge.model.Order;
import de.bockhorn.codechallenge.model.Product;
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

    /**
     * Maps the /post suburl to receive orders and
     * store the respective models in the database.
     * @param order Model of the order, which has been pre-mapped by Jackson ot the java class.
     * @return Displayed result string.
     */
    @PostMapping("/post")
    public String post(@RequestBody Order order) {
        return order.toString();
    }

    /**
     * Maps the /get suburl to present all order entries
     * that are stored in the database.
     * @return ResponseEntity containing of a list of orders and status.
     */
    @GetMapping("/get")
    public ResponseEntity<List<Order>> get() {

        List<Order> orders = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        Product product1 = new Product("Produkt 1", 3);
        Product product2 = new Product("Produkt 2", 5);

        products.add(product1);
        products.add(product2);

        orders.add(new Order(1, products));

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}
