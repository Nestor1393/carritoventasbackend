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
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_city;

    @Column(name = "city_name")
    private String city_name;

    @OneToMany(mappedBy = "id_city" /*,orphanRemoval = true*/)
    private Set<Address> addresses = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "id_state", nullable = true)
    @JsonIgnore
    private State id_state;

}
