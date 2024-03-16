package com.angularspringbootecommerce.backend.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "total")
    private BigDecimal total;
    @Column(name = "name")
    private String name;
    @Column(name = "address",length = 1000)
    private String address;
    @Column(name = "number")
    private Long number;
    @Column(name = "product_name")
    private String product_name;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
}
