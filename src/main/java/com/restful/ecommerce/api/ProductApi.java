package com.restful.ecommerce.api;


import com.restful.ecommerce.business.ProductService;
import com.restful.ecommerce.model.dto.ProductDto;
import com.restful.ecommerce.model.result.DataResult;
import com.restful.ecommerce.model.result.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/products")
@RestController
@RequiredArgsConstructor
public class ProductApi {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<DataResult<List<ProductDto>>> getAll(){
        return ResponseEntity.ok(
                this.productService.getAll()
        );
    }

    @PostMapping
    public ResponseEntity<DataResult<ProductDto>> add(@RequestBody ProductDto productDto){
        return ResponseEntity.ok(
          this.productService.add(productDto)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<ProductDto>> getById(@PathVariable long id){
        return ResponseEntity.ok(
                this.productService.getById(id)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable long id){
        return ResponseEntity.ok(
                this.productService.delete(id)
        );
    }

    @GetMapping("/category/{categoryName}")
    public ResponseEntity<DataResult<List<ProductDto>>> getByCategoryName(@PathVariable String categoryName){
        return ResponseEntity.ok(
              this.productService.getByCategoryName(categoryName)
            );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Result> update(@PathVariable(name = "id") long id,@RequestBody ProductDto productDto){
        return ResponseEntity.ok(
          this.productService.update(id,productDto)
        );
    }


}
