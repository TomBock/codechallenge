package de.bockhorn.codechallenge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * POJO Model class for Order with an ID, a product and the amount ordered.
 * Will automatically be mapped to the json format by Jackson (see dependencies).
 */
@Entity(name = "orders")
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {

    @Id
    @Column(name = "order_id")
    @Getter @Setter private long orderID;

    @OneToMany(mappedBy = "order")
    @Getter @Setter private List<Product> products;

}
