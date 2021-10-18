package com.restful.ecommerce.business.impl;

import com.restful.ecommerce.business.CategoryService;
import com.restful.ecommerce.model.dto.CategoryDto;
import com.restful.ecommerce.model.result.DataResult;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public DataResult<List<CategoryDto>> getAll() {
        return null;
    }

    @Override
    public DataResult<CategoryDto> add(CategoryDto categoryDto) {
        return null;
    }
}
