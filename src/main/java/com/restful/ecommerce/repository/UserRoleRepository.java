package com.restful.ecommerce.repository;

import com.restful.ecommerce.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {
    UserRole getUserRoleByUsername(String username);
}
