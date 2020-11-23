package de.bockhorn.codechallenge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * POJO Model class for Order with an ID, a product and the amount ordered.
 * Will automatically be mapped to the json format by Jackson (see dependencies).
 */
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter private int orderID;
    // The orderID is assumed to automatically be increased by VUE (frontend).

    @Column(columnDefinition = "text")
    @Getter @Setter private String products;

    @Override
    public String toString() {
        return "OrderModel{" +
                "orderID=" + orderID +
                ", products=" + products +
                '}';
    }
}
