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
@Table(name = "usuario"  /*, uniqueConstraints = @UniqueConstraint(columnNames = "user_name")*/)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "password")
    private String password;

    /*
    @OneToOne
    private Person id_person;
     */

    @ManyToOne
    @JoinColumn(name = "id_person", nullable = true)
    @JsonIgnore
    private Person id_person;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST )
    @JoinTable(
            name = "user_role",
            joinColumns = {
                    @JoinColumn(name = "id_user" /*, referencedColumnName = "id_user" */)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "id_role" /*, referencedColumnName = "id_role" */)
            }
    )
    private Set<Role> roles = new HashSet<>();



    @OneToMany(mappedBy = "id_user",  orphanRemoval = true)
    private Set<Order> orders = new HashSet<>();


    public User(String user_name, String password, Set<Role> roles) {
        this.user_name = user_name;
        this.password = password;
        this.roles = roles;
    }
}
