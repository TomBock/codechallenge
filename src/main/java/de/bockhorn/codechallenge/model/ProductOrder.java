package de.bockhorn.codechallenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Generated;

import javax.persistence.*;

/**
 * ProductOrder which describes one line in a database.
 * In this situation, the lack of additional information allows
 * for a simple table instead of a relational database with a relation
 * Order and a Product.
 */
@Entity
@Table(name = "productorders")
@NoArgsConstructor
public class ProductOrder {

    public ProductOrder(long orderID, String name, int amount) {
        this.orderID = orderID;
        this.name = name;
        this.amount = amount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    @Getter @Setter private long id;

    @Getter @Setter private long orderID;

    @Getter @Setter private String name;

    @Getter @Setter private int amount;
}
