package de.bockhorn.codechallenge.repository;

import de.bockhorn.codechallenge.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
