package com.angularspringbootecommerce.backend.services;

import com.angularspringbootecommerce.backend.models.Product;
import com.angularspringbootecommerce.backend.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }
    public void removeProductById(Long productId) {
        productRepository.deleteById(productId);
    }
    @Transactional
    public void deleteProductAndOrderItems(Long productId) {
        productRepository.updateOrderItemsWithNullProduct(productId);
        productRepository.deleteProductById(productId);
    }

    public Product add(Product product) {
        return productRepository.save(product);
    }
}
