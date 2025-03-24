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
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_address;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private Integer number;

    @Column(name = "locality")
    private String locality;

    @Column(name = "postal_code")
    private Integer postal_code;

    @OneToMany(mappedBy = "id_address",  orphanRemoval = true)
    private Set<Person> persons = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "id_city", nullable = false)
    @JsonIgnore
    private City id_city;

    public Address(Long id_address, String street, Integer number, String locality, Integer postal_code, City id_city) {
        this.id_address = id_address;
        this.street = street;
        this.number = number;
        this.locality = locality;
        this.postal_code = postal_code;
        this.id_city = id_city;
    }
}
