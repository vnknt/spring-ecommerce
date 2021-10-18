package com.restful.ecommerce;

import com.restful.ecommerce.business.CategoryService;
import com.restful.ecommerce.business.ProductService;
import com.restful.ecommerce.business.UserRoleService;
import com.restful.ecommerce.business.UserService;
import com.restful.ecommerce.business.impl.UserRoleServiceImpl;
import com.restful.ecommerce.business.impl.UserServiceImpl;
import com.restful.ecommerce.model.dto.CategoryDto;
import com.restful.ecommerce.model.dto.ProductDto;
import com.restful.ecommerce.model.dto.UserDto;
import com.restful.ecommerce.model.entity.Category;
import com.restful.ecommerce.model.entity.UserRole;
import com.restful.ecommerce.model.enums.ProductCategory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.lang.model.type.NullType;
import java.math.BigDecimal;
import java.util.ArrayList;

@SpringBootApplication
@EnableSwagger2
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}

	@Bean
	CommandLineRunner run(UserService userService ,
						  UserRoleService roleService,
						  CategoryService categoryService,
						  ProductService productService
						  ){

		return args -> {

			roleService.add(new UserRole(null,"ROLE_USER"));
			roleService.add(new UserRole(null,"ROLE_ADMIN"));

			userService.save(new UserDto(null,"Ahmet","Kanat","akanat21","123456",new ArrayList<>()));
			userService.save(new UserDto(null,"Fatma","Kanat","fkanat21","123456",new ArrayList<>()));
			userService.save(new UserDto(null,"Muhammed","Kanat","mkanat21","123456",new ArrayList<>()));

			userService.addRoleToUser("akanat21","ROLE_ADMIN");
			userService.addRoleToUser("fkanat21","ROLE_ADMIN");
			userService.addRoleToUser("mkanat21","ROLE_USER");

			categoryService.add(new CategoryDto(0,ProductCategory.BEVERAGE.name().toString()));
			categoryService.add(new CategoryDto(0,ProductCategory.COOKIE.name().toString()));
			categoryService.add(new CategoryDto(0,ProductCategory.CLEANING.name().toString()));
			categoryService.add(new CategoryDto(0,ProductCategory.MEAT.name().toString()));
			categoryService.add(new CategoryDto(0,ProductCategory.DAIRY.name().toString()));
			;


			productService.add(4,new ProductDto(
					null,
					"Lamb steak",
					new BigDecimal(1),
					20,
					new Category(0,ProductCategory.MEAT.name())
			));
			productService.add(4,new ProductDto(
					null,
					"Biff",
					new BigDecimal(1),
					20,
					new Category(0,ProductCategory.MEAT.name())
			));productService.add(5,new ProductDto(
					null,
					"Milk",
					new BigDecimal(1),
					20,
					new Category(0,ProductCategory.DAIRY.name())
			));
			productService.add(2,new ProductDto(
					null,
					"Cookie",
					new BigDecimal(1),
					20,
					new Category(0,ProductCategory.COOKIE.name())
			));

			productService.add(3,new ProductDto(
					null,
					"Tooth Paste",
					new BigDecimal(1),
					20,
					new Category(0,ProductCategory.CLEANING.name())
			));

			productService.add(1,new ProductDto(
					null,
					"Tea",
					new BigDecimal(1),
					20,
					new Category(0,ProductCategory.BEVERAGE.name())
			));
			productService.add(1,new ProductDto(
					null,
					"Cola",
					new BigDecimal(1),
					20,
					new Category(0,ProductCategory.BEVERAGE.name())
			));
			productService.add(1,new ProductDto(
					null,
					"Lemonate",
					new BigDecimal(1),
					20,
					new Category(0,ProductCategory.BEVERAGE.name())
			));

		};

	}
}
