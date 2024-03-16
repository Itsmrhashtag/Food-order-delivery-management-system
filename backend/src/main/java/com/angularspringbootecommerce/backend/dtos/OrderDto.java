package com.angularspringbootecommerce.backend.dtos;

import com.angularspringbootecommerce.backend.models.OrderItem;
import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDto {
    private Long id;
    private String dateCreated;
    private BigDecimal total;
    private String name;
    private String address;
    private Long number;
    private String product_name;

}