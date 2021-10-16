package com.restful.ecommerce.business.impl;

import com.restful.ecommerce.business.UserService;
import com.restful.ecommerce.model.dto.UserDto;
import com.restful.ecommerce.model.result.DataResult;
import com.restful.ecommerce.model.result.Result;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public DataResult<UserDto> save(UserDto userDto) {
        return null;
    }

    @Override
    public DataResult<UserDto> getById(String id) {
        return null;
    }

    @Override
    public DataResult<UserDto> getByUsername(String username) {
        return null;
    }

    @Override
    public Result addRoleToUser(String username, String roleName) {
        return null;
    }
}
