package com.restful.ecommerce.business;


import com.restful.ecommerce.model.dto.CategoryDto;
import com.restful.ecommerce.model.entity.Category;
import com.restful.ecommerce.model.result.DataResult;

import java.util.List;

public interface CategoryService  {


    DataResult<List<CategoryDto>> getAll();
    DataResult<CategoryDto> add(CategoryDto categoryDto);


}
