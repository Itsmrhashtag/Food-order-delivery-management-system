package com.angularspringbootecommerce.backend.dtos;

import com.angularspringbootecommerce.backend.models.OrderItem;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String imgUrl;
}
