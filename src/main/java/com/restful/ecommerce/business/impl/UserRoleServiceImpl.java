package com.restful.ecommerce.business.impl;

import com.restful.ecommerce.business.UserRoleService;
import com.restful.ecommerce.model.entity.UserRole;
import com.restful.ecommerce.model.result.DataResult;
import com.restful.ecommerce.model.result.ErrorDataResult;
import com.restful.ecommerce.model.result.SuccessDataResult;
import com.restful.ecommerce.repository.UserRepository;
import com.restful.ecommerce.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    @Override
    public DataResult<UserRole> getRoleByName(String roleName) {
        UserRole role = this.userRoleRepository.getByName(roleName);
        return new SuccessDataResult<>(role);
    }

    @Override
    public DataResult<UserRole> add(UserRole role) {
        try{
            this.userRoleRepository.save(role);
        }catch (Exception e){
            return new ErrorDataResult(role,e.getMessage());
        }
        return new SuccessDataResult<>();
    }

}
