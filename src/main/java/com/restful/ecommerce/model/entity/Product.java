package com.restful.ecommerce.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="productId")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "quantity")
    private int quantity;


    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "type")
    private ProductType type;

}
