package com.restful.ecommerce.business.impl;

import com.restful.ecommerce.business.ProductService;
import com.restful.ecommerce.model.dto.ProductDto;
import com.restful.ecommerce.model.entity.Product;
import com.restful.ecommerce.model.result.*;
import com.restful.ecommerce.repository.CategoryRepository;
import com.restful.ecommerce.repository.ProductRepository;
import com.restful.ecommerce.utils.ProductConverter;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private ProductConverter productConverter;



    @Override
    public DataResult<ProductDto> add(ProductDto productDto) {
        Product product = productConverter.convertToProduct(productDto);
        try {
            productRepository.save(product);
        }catch (Exception e){
            return new ErrorDataResult<>();
        }
        return new SuccessDataResult<>(productDto);
    }

    @Override
    public DataResult<ProductDto> update(long id,ProductDto productDto) {

        try{
            Product product = productRepository.getById(id);
            product.setName(productDto.getName());
            product.setCategory(productDto.getCategory());
            product.setPrice(productDto.getPrice());
            product.setQuantity(productDto.getQuantity());
            productRepository.save(product);
        }catch (Exception e){
            return new ErrorDataResult<>();
        }
        return new SuccessDataResult<>(productDto);
    }

    @Override
    public Result delete(long id) {
        Product product = productRepository.getById(id);
        try{
            productRepository.delete(product);
        }catch (Exception e){
            return new ErrorResult();
        }
        return new SuccessResult();
    }

    @Override
    public DataResult<List<ProductDto>> getAll() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = productConverter.convertList(products);
        return new SuccessDataResult<>(productDtos);
    }

    @Override
    public DataResult<List<ProductDto>> getByCategory(String categoryName) {
        List<Product> products = productRepository.getByCategory_CategoryName(categoryName);
        List<ProductDto> productDtos = productConverter.convertList(products);
        return new SuccessDataResult<>(productDtos);

    }

    @Override
    public DataResult<ProductDto> getById(long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return new ErrorDataResult<>("Product Doesn't exist");
        }
        return new SuccessDataResult(product);
    }
}
