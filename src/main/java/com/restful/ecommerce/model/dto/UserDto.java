package com.restful.ecommerce.model.dto;

import com.restful.ecommerce.model.entity.UserRole;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@Builder
public class UserDto {

    private Long id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private Collection<UserRole> roles;

}
