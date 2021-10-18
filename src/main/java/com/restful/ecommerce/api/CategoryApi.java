package com.restful.ecommerce.api;

import com.restful.ecommerce.business.CategoryService;
import com.restful.ecommerce.model.dto.CategoryDto;
import com.restful.ecommerce.model.result.DataResult;
import com.restful.ecommerce.model.result.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryApi {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<DataResult<List<CategoryDto>>> getAll(){
        return ResponseEntity.ok(
                this.categoryService.getAll()
        );
    }


    @PostMapping
    public ResponseEntity<DataResult<CategoryDto>> add(@RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(this.categoryService.add(categoryDto));
    }


}
