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
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_customer;

   /* @OneToOne
    private Person id_person;
    */

    @ManyToOne
    @JoinColumn(name = "id_person", nullable = true)
    @JsonIgnore
    private Person id_person;


    @OneToMany(mappedBy = "id_customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Order> orders = new HashSet<>();

    public Customer(Long id_customer, Set<Order> orders) {
        this.id_customer = id_customer;
        this.orders = orders;
    }
}
