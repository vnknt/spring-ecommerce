package com.restful.ecommerce.business;

import com.restful.ecommerce.model.entity.UserRole;
import com.restful.ecommerce.model.result.DataResult;

public interface UserRoleService {
    DataResult<UserRole> getRoleByName(String roleName );
    DataResult<UserRole> add(UserRole role);

}
