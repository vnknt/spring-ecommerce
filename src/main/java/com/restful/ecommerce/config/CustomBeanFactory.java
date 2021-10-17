package com.restful.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;
@Component
public class CustomBeanFactory {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
