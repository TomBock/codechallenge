package de.bockhorn.codechallenge;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    @PostMapping("/post")
    public String post(@RequestBody Order order) {
        return order.toString();
    }

    @GetMapping("/get")
    public ResponseEntity<List<Order>> get() {

        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "Produkt 1", 3));
        orders.add(new Order(2, "Produkt 2", 5));

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}
