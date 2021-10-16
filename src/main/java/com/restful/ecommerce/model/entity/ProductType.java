package com.restful.ecommerce.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_types")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productTypeId")
    private int productTypeId;

    @Column(name="productTypeName")
    private int productTypeName;
}
