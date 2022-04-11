package com.test.springframework.domain.repogitory;


import com.test.springframework.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
