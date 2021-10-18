package com.restful.ecommerce.utils;


import com.restful.ecommerce.model.dto.CategoryDto;
import com.restful.ecommerce.model.entity.Category;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryDtoConverter {
    private final ModelMapper modelMapper;

    public CategoryDto convert(Category category){
        return modelMapper.map(category,CategoryDto.class);
    }

    public Category convertToCategory(CategoryDto categoryDto){
        return modelMapper.map(categoryDto,Category.class);
    }

    public List<CategoryDto> convertList(List<Category> categories){
        List<CategoryDto> categoryDtos = new ArrayList<>();
        categories.forEach(category -> {
            categoryDtos.add(modelMapper.map(category,CategoryDto.class));
        });
        return categoryDtos;
    }


}
