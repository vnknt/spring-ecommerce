package com.restful.ecommerce.business;

import com.restful.ecommerce.model.dto.UserDto;
import com.restful.ecommerce.model.result.DataResult;
import com.restful.ecommerce.model.result.Result;

import java.util.List;

public interface UserService {

    DataResult<UserDto> save(UserDto userDto);
    DataResult<List<UserDto>> getAll();
    DataResult<UserDto> getByUsername(String username);
    Result addRoleToUser(String username, String roleName);

}
