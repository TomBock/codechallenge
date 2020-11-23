package de.bockhorn.codechallenge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * POJO Model class for Order with an ID, a product and the amount ordered.
 * Will automatically be mapped to the json format by Jackson (see dependencies).
 */
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Getter @Setter private long orderID;

    @Getter @Setter private List<Map<String, String>> products;

    /**
     * Changes the format for easier storage
     * @return a list of ProductOrder classes
     */
    public List<ProductOrder> getProductOrders() {
        List<ProductOrder> productOrders = new ArrayList<>();
        products.forEach(
                productData -> productOrders.add(
                        new ProductOrder(
                                orderID,
                                productData.get("name"),
                                Integer.parseInt(productData.get("amount")
                                )
                        )
                )
        );
        return productOrders;
    }
}
