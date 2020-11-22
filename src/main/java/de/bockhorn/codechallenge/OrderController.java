package de.bockhorn.codechallenge;

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
    public String post(@RequestBody OrderModel order) {
        return order.toString();
    }

    /**
     * Maps the /get suburl to present all order entries
     * that are stored in the database.
     * @return ResponseEntity containing of a list of orders and status.
     */
    @GetMapping("/get")
    public ResponseEntity<List<OrderModel>> get() {

        List<OrderModel> orders = new ArrayList<>();
        orders.add(new OrderModel(1, "Produkt 1", 3));
        orders.add(new OrderModel(2, "Produkt 2", 5));

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}
