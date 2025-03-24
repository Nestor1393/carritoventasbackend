package com.ventas.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_supplier;

    @Column(name = "supplier_name")
    private String supplier_name;

    @ManyToOne
    @JoinColumn(name = "id_category", nullable = true)
    @JsonIgnore
    private Category id_category;

    @OneToMany(mappedBy = "id_supplier", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Product> products = new HashSet<>();

    public Supplier(Long id_supplier, String supplier_name) {
        this.id_supplier = id_supplier;
        this.supplier_name = supplier_name;
    }
}