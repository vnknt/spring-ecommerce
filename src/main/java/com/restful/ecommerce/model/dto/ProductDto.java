package com.restful.ecommerce.model.dto;

import com.restful.ecommerce.model.entity.ProductType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {

    private Long id;
    private String name;
    private BigDecimal price;
    private int quantity;
    private ProductType type;

}
