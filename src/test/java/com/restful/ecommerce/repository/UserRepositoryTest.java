package com.restful.ecommerce.repository;

import com.restful.ecommerce.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;

    @Test
    public void testGetByUsername(){
        User user = new User();
        user.setId(null);
        user.setName("test_name");
        user.setSurname("test_surname");
        user.setUsername("test_username");
        user.setPassword("test_password");

        Mockito.when(userRepository.getByUsername("test_username")).thenReturn(user);

        User userResult = userRepository.getByUsername("test_username");

        Assertions.assertEquals(userResult,user);

        Mockito.verify(userRepository).getByUsername("test_username");


    }
}