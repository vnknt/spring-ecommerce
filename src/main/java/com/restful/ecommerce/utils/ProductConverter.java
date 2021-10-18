package com.restful.ecommerce.utils;

import com.restful.ecommerce.model.dto.ProductDto;
import com.restful.ecommerce.model.dto.UserDto;
import com.restful.ecommerce.model.entity.Product;
import com.restful.ecommerce.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductConverter {
    private final ModelMapper modelMapper;

    public ProductDto convert(Product product){
        return modelMapper.map(product,ProductDto.class);
    }
    public Product convertToProduct(ProductDto productDto){
        return modelMapper.map(productDto,Product.class);
    }

    public List<ProductDto> convertList(List<Product> products){
        List<ProductDto> dtos = new ArrayList<>();
        products.forEach(product -> {
            dtos.add(
                    modelMapper.map(product,ProductDto.class)
            );
        });
        return dtos;
    }



}
