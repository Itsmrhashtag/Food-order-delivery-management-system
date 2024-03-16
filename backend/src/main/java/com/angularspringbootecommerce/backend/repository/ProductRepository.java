package com.angularspringbootecommerce.backend.repository;

import com.angularspringbootecommerce.backend.models.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE OrderItem oi SET oi.product = null WHERE oi.product.id = :productId")
    void updateOrderItemsWithNullProduct(Long productId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Product p WHERE p.id = :productId")
    void deleteProductById(Long productId);
}
