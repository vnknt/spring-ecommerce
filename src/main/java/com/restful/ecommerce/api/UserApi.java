package com.restful.ecommerce.api;

import com.restful.ecommerce.business.UserService;
import com.restful.ecommerce.model.dto.UserDto;
import com.restful.ecommerce.model.result.DataResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserApi {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<DataResult<List<UserDto>>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }




}
