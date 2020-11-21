package de.bockhorn.codechallenge;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Order {

    @Getter @Setter int orderID;
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
