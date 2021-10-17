package com.restful.ecommerce.utils;

import com.restful.ecommerce.model.dto.UserDto;
import com.restful.ecommerce.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserDtoConverter {

    private final ModelMapper modelMapper;


    public UserDto convert(User user){
        UserDto dto = modelMapper.map(user,UserDto.class);
        return dto;
    }

    public User convertToUser(UserDto dto){
        User user = modelMapper.map(dto,User.class);
        return user;
    }

    public List<UserDto> convertList(List<User> users){
        List<UserDto> dtos = new ArrayList<>();
        users.forEach(user -> {
            dtos.add(
                    modelMapper.map(user,UserDto.class)
            );
        });
        return dtos;
    }



}
