package de.bockhorn.codechallenge.controller;

import de.bockhorn.codechallenge.model.Order;
import de.bockhorn.codechallenge.model.ProductOrder;
import de.bockhorn.codechallenge.repository.ProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for all order related topics
 * Functions: post & get
 */
@RestController
public class OrderController {

    @Autowired
    private ProductOrderRepository productOrderRepository;

    /**
     * Maps the /post suburl to receive orders and
     * store the respective models in the database.
     * @param order Model of the order, which has been pre-mapped by Jackson ot the java class.
     * @return Displayed result string.
     */
    @PostMapping(value = "/post")
    public ResponseEntity<HttpStatus> post(@RequestBody Order order) {
        productOrderRepository.saveAll(order.getProductOrders());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Maps the /get suburl to present all order entries
     * that are stored in the database.
     * @return ResponseEntity containing of a list of orders and status.
     */
    @GetMapping("/get")
    public List<ProductOrder> get() {
        return productOrderRepository.findAll();
    }

}
