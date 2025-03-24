package com.ventas.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_person;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "email")
    private String email;

    @Column(name = "id_facebook")
    private String idFacebook;

    @Column(name = "id_google")
    private String idGoogle;


    @ManyToOne
    @JoinColumn(name = "id_address", nullable = true)
    @JsonIgnore
    private Address id_address;

    @OneToMany(mappedBy = "id_person",  orphanRemoval = true)
    private Set<Customer> customers = new HashSet<>();

    @OneToMany(mappedBy = "id_person",  orphanRemoval = true)
    private Set<User> users = new HashSet<>();


    public Person(Long id_person, String first_name, String last_name, LocalDate birthdate, String email) {
        this.id_person = id_person;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birthdate = birthdate;
        this.email = email;
    }
}
