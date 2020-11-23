package de.bockhorn.codechallenge.repository;

import de.bockhorn.codechallenge.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for ProductOrders
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
