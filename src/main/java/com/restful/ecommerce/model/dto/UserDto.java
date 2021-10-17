package com.restful.ecommerce.model.dto;

import com.restful.ecommerce.model.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    private Long id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private Collection<UserRole> roles;

}
