package com.restful.ecommerce.business.impl;

import com.restful.ecommerce.business.CategoryService;
import com.restful.ecommerce.model.dto.CategoryDto;
import com.restful.ecommerce.model.entity.Category;
import com.restful.ecommerce.model.result.DataResult;
import com.restful.ecommerce.model.result.ErrorDataResult;
import com.restful.ecommerce.model.result.SuccessDataResult;
import com.restful.ecommerce.repository.CategoryRepository;
import com.restful.ecommerce.utils.CategoryDtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryDtoConverter categoryDtoConverter;
    @Override
    public DataResult<List<CategoryDto>> getAll() {

        List<Category> categories = this.categoryRepository.findAll();
        return new SuccessDataResult<>(
                categoryDtoConverter.convertList(categories)
        );

    }

    @Override
    public DataResult<CategoryDto> add(CategoryDto categoryDto) {
        Category category = categoryDtoConverter.convertToCategory(categoryDto);
        try{
            this.categoryRepository.save(category);
        }catch (Exception e){
            return new ErrorDataResult<>();
        }
        return new SuccessDataResult<>(categoryDto);
    }
}
