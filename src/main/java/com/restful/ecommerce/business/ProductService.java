package com.restful.ecommerce.business;

import com.restful.ecommerce.model.dto.ProductDto;
import com.restful.ecommerce.model.result.DataResult;
import com.restful.ecommerce.model.result.Result;

import java.util.List;

public interface ProductService {
    DataResult<ProductDto> add(int categoryId,ProductDto productDto);
    DataResult<ProductDto> update(long id,ProductDto productDto);
    Result delete(long id);
    DataResult<List<ProductDto>> getAll();
    DataResult<List<ProductDto>> getByCategoryName(String categoryName);
    DataResult<ProductDto> getById(long id);

}
