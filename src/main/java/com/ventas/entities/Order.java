package com.ventas.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orden")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_order;

    @Column(name = "folio")
    private String folio;

    @Column(name = "subtotal")
    private Double subtotal;

    @Column(name = "total")
    private Double total;

    @Column(name = "codigo_barras")
    private Long barcode;

    @Column(name = "order_date")
    private LocalDateTime order_date;

    @OneToMany(mappedBy = "id_order", orphanRemoval = true)
    private Set<OrderDetail> orderDetails = new HashSet<>();


    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    @JsonIgnore
    private User id_user;

    @ManyToOne
    @JoinColumn(name = "id_customer", nullable = false)
    @JsonIgnore
    private Customer id_customer;
}
