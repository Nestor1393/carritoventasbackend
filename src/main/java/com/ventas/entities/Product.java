package com.ventas.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_product;

    @Column(name = "product_name")
    private String product_name;

    @Column(name = "price")
    private Double price;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "product_code")
    private String product_code;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_supplier", nullable = true)
    @JsonIgnore
    private Supplier id_supplier;

    @OneToMany(mappedBy = "id_product",  orphanRemoval = true)
    private Set<OrderDetail> orderDetails = new HashSet<>();

    public Product(Long id_product, String product_name, Double price, Integer stock, String product_code, String description) {
        this.id_product = id_product;
        this.product_name = product_name;
        this.price = price;
        this.stock = stock;
        this.product_code = product_code;
        this.description = description;
    }
}
