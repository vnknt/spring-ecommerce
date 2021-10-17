package com.restful.ecommerce.business.impl;

import com.restful.ecommerce.business.UserService;
import com.restful.ecommerce.model.dto.UserDto;
import com.restful.ecommerce.model.entity.User;
import com.restful.ecommerce.model.entity.UserRole;
import com.restful.ecommerce.model.result.*;
import com.restful.ecommerce.repository.UserRepository;
import com.restful.ecommerce.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final ModelMapper modelMapper;


    @Override
    public DataResult<UserDto> save(UserDto userDto) {
        User user = modelMapper.map(userDto,User.class);
        try{
            userRepository.save(user);

        }catch (Exception e){
            return new ErrorDataResult<>(userDto,e.getMessage());
        }
        return new SuccessDataResult<>(userDto);
    }


    @Override
    public DataResult<List<UserDto>> getAll() {

        List<User> users = this.userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user->{
            userDtos.add(modelMapper.map(user,UserDto.class));
        });

        return new SuccessDataResult<>(userDtos);
    }

    @Override
    public DataResult<UserDto> getByUsername(String username) {
        User user = this.userRepository.getByUsername(username);
        UserDto userDto= modelMapper.map(user,UserDto.class);
        return new SuccessDataResult<>(
            userDto
        );
    }

    @Override
    public Result addRoleToUser(String username, String roleName) {

        UserRole role = userRoleRepository.getByName(roleName);
        User user = userRepository.getByUsername(username);

        if (role == null) {
            return new ErrorResult("Role not found");
        }
        if (user == null) {
            return new ErrorResult("User not found");

        }

        Collection<UserRole> roles = user.getRoles();
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
        return new SuccessResult();

    }
}
