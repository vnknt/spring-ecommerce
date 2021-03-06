package com.restful.ecommerce.business.impl;

import com.restful.ecommerce.business.UserService;
import com.restful.ecommerce.model.dto.UserDto;
import com.restful.ecommerce.model.entity.User;
import com.restful.ecommerce.model.entity.UserRole;
import com.restful.ecommerce.model.result.*;
import com.restful.ecommerce.repository.UserRepository;
import com.restful.ecommerce.repository.UserRoleRepository;
import com.restful.ecommerce.utils.UserDtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final UserDtoConverter userDtoConverter;
    private final PasswordEncoder passwordEncoder;
    @Override
    public DataResult<UserDto> save(UserDto userDto) {
        User user = userDtoConverter.convertToUser(userDto);
        user.setPassword(
            passwordEncoder.encode(user.getPassword())
        );
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
        List<UserDto> userDtos = userDtoConverter.convertList(users);

        return new SuccessDataResult<>(userDtos);
    }

    @Override
    public DataResult<UserDto> getByUsername(String username) {
        User user = this.userRepository.getByUsername(username);

        if(user==null){
            return new ErrorDataResult<>();
        }

        UserDto userDto= userDtoConverter.convert(user);
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

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User appUser = this.userRepository.getByUsername(s);
        if(appUser == null){
            throw new UsernameNotFoundException("User not found for given username");
        }
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        appUser.getRoles().forEach(role->{
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(appUser.getUsername(),appUser.getPassword(),authorities);

    }
}
