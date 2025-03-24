package com.ventas.entities;


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
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_category;

    @Column(name = "category_name")
    private String category_name;

    @OneToMany(mappedBy = "id_category", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY,orphanRemoval = true)
    private Set<Supplier> suppliers = new HashSet<>();

    public Category(Long id_category, String category_name) {
        this.id_category = id_category;
        this.category_name = category_name;
    }
}
