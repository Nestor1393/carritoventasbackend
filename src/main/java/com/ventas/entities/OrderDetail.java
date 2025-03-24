package com.ventas.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_order_detail;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "costo")
    private Double costo;

    @ManyToOne
    @JoinColumn(name = "id_product", nullable = true)
    @JsonIgnore
    private Product id_product;

    @ManyToOne
    @JoinColumn(name = "id_order", nullable = true)
    @JsonIgnore
    private Order id_order;


}
