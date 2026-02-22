package com.example.demo.product.controller;

import com.example.demo.common.dto.ProductRes;
import com.example.demo.product.dto.CategoryReq;
import com.example.demo.product.dto.CategoryRes;
import com.example.demo.product.dto.ProductsRes;
import com.example.demo.product.entity.CategoriesEntity;
import com.example.demo.product.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @RequestMapping("/create")
    public ResponseEntity createCategory(@RequestBody CategoryReq categoryReq){
        categoryService.saveCategory(categoryReq);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/get-all")
    public ResponseEntity <List<CategoryRes>> getall()
    {
        List<CategoryRes> categoryResList = categoryService.findAll();
        return ResponseEntity.ok(categoryResList);
    }
}
