package com.restful.ecommerce.model.dto;

import com.restful.ecommerce.model.entity.UserRole;

import javax.persistence.*;
import java.util.Collection;

public class UserDto {

    private int id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private Collection<UserRole> roles;

}
