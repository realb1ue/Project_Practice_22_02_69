package com.example.demo.product.service;

import com.example.demo.common.dto.ProductRes;
import com.example.demo.common.entity.Productentity;
import com.example.demo.product.dto.CategoryReq;
import com.example.demo.product.dto.CategoryRes;
import com.example.demo.product.dto.ProductsRes;
import com.example.demo.product.entity.CategoriesEntity;
import com.example.demo.product.entity.ProductsEntity;
import com.example.demo.product.repository.CategoriesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private final CategoriesRepository categoriesRepository;

    public CategoryService(CategoriesRepository categoriesRepository){
        this.categoriesRepository = categoriesRepository;
    }

    public void saveCategory(CategoryReq categoryReq){
        CategoriesEntity categoriesEntity = new CategoriesEntity();
        categoriesEntity.setName(categoryReq.getName());
        categoriesEntity.setDescription(categoryReq.getDescription());
        categoriesRepository.save(categoriesEntity);
    }

    public List<CategoryRes>findAll(){
        List<CategoryRes> categoryResList = new ArrayList<>();
        List<CategoriesEntity> categoriesEntities = (List<CategoriesEntity>) categoriesRepository.findAll();
        for (int i=0;i<categoriesEntities.size();i++){
            CategoryRes categoryRes = new CategoryRes();
            categoryRes.setName(categoriesEntities.get(i).getName());
            categoryRes.setDescription(categoriesEntities.get(i).getDescription());
            categoryRes.setId(categoriesEntities.get(i).getId());
            categoryResList.add(categoryRes);
        }
        return categoryResList;
    }

}
