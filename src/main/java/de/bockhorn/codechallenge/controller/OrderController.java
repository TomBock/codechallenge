package de.bockhorn.codechallenge.controller;

import de.bockhorn.codechallenge.model.Order;
import de.bockhorn.codechallenge.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for mapping urls and launching service functions.
 * Functions: post & get
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * Maps the /post suburl to receive orders and
     * tells the service to save this order.
     */
    @PostMapping(value = "/post")
    public ResponseEntity<HttpStatus> post(@RequestBody Order order) {
        orderService.save(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Maps the /get suburl to present all order entries
     * that are stored in the database.
     * @return ResponseEntity containing of a list of orders and status.
     */
    @GetMapping("/get")
    public ResponseEntity<List<Order>> get() {
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }
}
