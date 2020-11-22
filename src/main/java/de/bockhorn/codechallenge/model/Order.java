package de.bockhorn.codechallenge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * POJO Model class for Order with an ID, a product and the amount ordered.
 * Will automatically be mapped to the json format by Jackson (see dependencies).
 */
@AllArgsConstructor
public class Order {

    // The orderID is assumed to automatically be increased by VUE (frontend).
    @Getter @Setter int orderID;

    @Getter @Setter private List<Product> products;

    @Override
    public String toString() {
        return "OrderModel{" +
                "orderID=" + orderID +
                ", products=" + products +
                '}';
    }
}
