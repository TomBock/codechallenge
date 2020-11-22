package de.bockhorn.codechallenge;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * POJO Model class for Order with an ID, a product and the amount ordered.
 * Will automatically be mapped to the json format by Jackson (see dependencies).
 */
@AllArgsConstructor
public class OrderModel {

    @Getter @Setter int orderID;
    // The orderID is assumed to automatically be increased by VUE (frontend).

    @Getter @Setter private String product;
    @Getter @Setter private int amount;

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", product='" + product + '\'' +
                ", amount=" + amount +
                '}';
    }
}
