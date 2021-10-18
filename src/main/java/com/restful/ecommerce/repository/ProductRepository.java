package com.restful.ecommerce.repository;

import com.restful.ecommerce.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> getByCategory_CategoryName(String name);
}
