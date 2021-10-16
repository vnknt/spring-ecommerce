package com.restful.ecommerce.business.impl;

import com.restful.ecommerce.business.UserRoleService;
import com.restful.ecommerce.model.entity.UserRole;
import com.restful.ecommerce.model.result.DataResult;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Override
    public DataResult<UserRole> getRoleByName(String roleName) {
        return null;
    }

    @Override
    public DataResult<UserRole> add(UserRole role) {
        return null;
    }

}
