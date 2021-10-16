package com.restful.ecommerce.business;

import com.restful.ecommerce.model.dto.UserDto;
import com.restful.ecommerce.model.result.DataResult;
import com.restful.ecommerce.model.result.Result;

public interface UserService {

    DataResult<UserDto> save(UserDto userDto);
    DataResult<UserDto> getById(String id);
    DataResult<UserDto> getByUsername(String username);
    Result addRoleToUser(String username, String roleName);

}
