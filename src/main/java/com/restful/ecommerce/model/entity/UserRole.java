package com.restful.ecommerce.model.entity;

import javax.persistence.*;

@Entity
@Table(name="roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="roleId")
    private int id;

    @Column(name = "roleName")
    private String name;
}
