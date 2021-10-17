package com.restful.ecommerce.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<UserRole> roles;

}
