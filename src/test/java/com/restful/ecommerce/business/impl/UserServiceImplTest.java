package com.restful.ecommerce.business.impl;
import com.restful.ecommerce.model.dto.UserDto;
import com.restful.ecommerce.model.entity.User;
import com.restful.ecommerce.model.entity.UserRole;
import com.restful.ecommerce.model.result.DataResult;
import com.restful.ecommerce.model.result.ErrorDataResult;
import com.restful.ecommerce.model.result.Result;
import com.restful.ecommerce.model.result.SuccessDataResult;
import com.restful.ecommerce.repository.UserRepository;
import com.restful.ecommerce.repository.UserRoleRepository;
import com.restful.ecommerce.utils.UserDtoConverter;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private  UserRepository userRepository;

    @Mock
    private  UserRoleRepository userRoleRepository;

    @Mock
    private UserDtoConverter userDtoConverter;
    @InjectMocks
    private UserServiceImpl userService;

    private final UserDto userDto = UserDto.builder()
                                    .id(null)
                                    .name("test_name")
                                    .surname("test_surname")
                                    .username("test_username")
                                    .password("test_password")
                                    .roles(new ArrayList<>())
                                    .build();

    private final User user = User.builder()
                                .id(null)
                                .name("test_name")
                                .surname("test_surname")
                                .username("test_username")
                                .password("test_password")
                                .roles(new ArrayList<>())
                                .build();



    @Test
    public void whenSaveUserCalledWithValidUserDto_ThenReturnSuccessDataResultForUserDto(){


        Mockito.when(userRepository.save(user)).thenReturn(user);
        Mockito.when(userDtoConverter.convertToUser(userDto)).thenReturn(user);

        DataResult<UserDto> result = userService.save(userDto);

        Assertions.assertEquals(result,new SuccessDataResult<>(userDto));


    }

    public void whenSaveCalledWithInvalidUserDto_ThenReturnErrorDataResult(){
        //TODO: Add BusinessRules to check if UserDto is valid or not
    }

    public void whenGetAllCalled_ThenReturnSuccessDataResultForUserDtos(){
        //Todo: Write Test For getAll Method
    }


    @Test
    public void whenCalledGetByUsernameWithValidUsername_ThenReturnValidUser(){
        User userMock = Mockito.mock(User.class);

        Mockito.when(userRepository.getByUsername(ArgumentMatchers.any())).thenReturn(user);
        Mockito.when(userDtoConverter.convert(user)).thenReturn(userDto);

        DataResult<UserDto> result = userService.getByUsername("test_username");
        Assertions.assertEquals(result.getData(),userDto);

        Mockito.verify(userRepository).getByUsername("test_username");
        Mockito.verify(userDtoConverter).convert(user);

    }


    @Test
    public void whenGetByUsernameCalledWithNonExistingUsername_ThenReturnErrorDataResult(){
        final String invalid_username = "invalid_username";
        Mockito.when(userRepository.getByUsername(invalid_username)).thenReturn(null);

        DataResult<UserDto> result = userService.getByUsername(invalid_username);

        Assertions.assertEquals(result,new ErrorDataResult<>());

        Mockito.verify(userRepository).getByUsername(invalid_username);


    }

    @Test
    public void whenAddRoleToUserCalledWithExistingUsernameAndExistingRolename_ThenReturnSuccessResult(){

        UserRole userRole = UserRole.builder()
                                    .id(null)
                                    .name("test_role")
                                    .build();

        Mockito.when(userRoleRepository.getByName("test_role")).thenReturn(userRole);
        Mockito.when(userRepository.getByUsername("test_username")).thenReturn(user);

        Result result = userService.addRoleToUser(user.getUsername(),userRole.getName());

        Assertions.assertTrue(result.isSuccess());

        Mockito.verify(userRepository).getByUsername("test_username");
        Mockito.verify(userRoleRepository).getByName("test_role");
    }

    @Test
    public void whenAddRoleToUserCalledWithNonExistingUsername_ThenReturnErrorResult(){
        UserRole userRole = UserRole.builder()
                .id(null)
                .name("test_role")
                .build();
        Mockito.when(userRepository.getByUsername("invalid_username")).thenReturn(null);
        Mockito.when(userRoleRepository.getByName("test_role")).thenReturn(userRole);

        Result result = userService.addRoleToUser("invalid_username","test_role");

        Assertions.assertFalse(result.isSuccess());

    }


    @Test
    public void whenAddRoleToUserCalledWithNonExistingRolename_ThenReturnErrorResult(){

        Mockito.when(userRepository.getByUsername("test_username")).thenReturn(user);
        Mockito.when(userRoleRepository.getByName("invalid_role")).thenReturn(null);

        Result result = userService.addRoleToUser("test_username","invalid_role");

        Assertions.assertFalse(result.isSuccess());
    }





}