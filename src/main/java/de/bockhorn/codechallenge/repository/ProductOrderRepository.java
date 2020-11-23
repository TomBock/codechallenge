package de.bockhorn.codechallenge.repository;

import de.bockhorn.codechallenge.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for ProductOrders
 */
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {
}
