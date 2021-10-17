package com.restful.ecommerce;

import com.restful.ecommerce.business.UserRoleService;
import com.restful.ecommerce.business.UserService;
import com.restful.ecommerce.business.impl.UserRoleServiceImpl;
import com.restful.ecommerce.business.impl.UserServiceImpl;
import com.restful.ecommerce.model.dto.UserDto;
import com.restful.ecommerce.model.entity.UserRole;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService ,UserRoleService roleService ){

		return args -> {
			roleService.add(new UserRole(null,"ROLE_USER"));
			roleService.add(new UserRole(null,"ROLE_ADMIN"));

			userService.save(new UserDto(null,"Ahmet","Kanat","akanat21","123456",new ArrayList<>()));
			userService.save(new UserDto(null,"Fatma","Kanat","fkanat21","123456",new ArrayList<>()));
			userService.save(new UserDto(null,"Muhammed","Kanat","mkanat21","123456",new ArrayList<>()));

			userService.addRoleToUser("akanat21","ROLE_ADMIN");
			userService.addRoleToUser("fkanat21","ROLE_ADMIN");
			userService.addRoleToUser("mkanat21","ROLE_USER");




		};

	}
}
