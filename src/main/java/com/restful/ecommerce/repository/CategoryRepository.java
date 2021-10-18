package com.restful.ecommerce.repository;

import com.restful.ecommerce.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
