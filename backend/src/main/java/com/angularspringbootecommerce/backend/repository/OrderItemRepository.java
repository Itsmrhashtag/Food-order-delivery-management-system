package com.angularspringbootecommerce.backend.repository;

import com.angularspringbootecommerce.backend.models.Order;
import com.angularspringbootecommerce.backend.models.OrderItem;
import com.angularspringbootecommerce.backend.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<Product> findProductById(Long prodId);
}
