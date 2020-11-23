package de.bockhorn.codechallenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Product which describes the purchased product and its amount.
 * In this situation, the lack of additional information allows
 * for one relation instead of further separations.
 */
@Entity(name = "products")
@Table(name = "products")
@NoArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    @JsonIgnore
    @Getter @Setter private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_order")
    @JsonIgnore
    @Getter @Setter private Order order;

    @Column(name = "name")
    @Getter @Setter private String name;

    @Column(name = "amount")
    @Getter @Setter private int amount;

}
