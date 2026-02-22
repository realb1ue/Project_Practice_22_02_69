package com.example.demo.product.service;


import com.example.demo.common.dto.ProductReq;
import com.example.demo.common.dto.ProductRes;
import com.example.demo.common.entity.Productentity;
import com.example.demo.product.dto.ProductsReq;
import com.example.demo.product.dto.ProductsRes;
import com.example.demo.product.dto.SellProductReq;
import com.example.demo.product.entity.ProductsEntity;
import com.example.demo.product.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsService {
    private final ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository){
        this.productsRepository = productsRepository;
    }

    public void saveProducts(ProductsReq productsReq){
        ProductsEntity productsEntity = new ProductsEntity();
        productsEntity.setCategoryId(productsReq.getCategoryId());
        productsEntity.setName(productsReq.getName());
        productsEntity.setStock(productsReq.getStock());
        productsEntity.setPrice(productsReq.getPrice());
        productsEntity.setDescription(productsReq.getDescription());
        productsRepository.save(productsEntity);
    }

    public List<ProductsRes>findAll(){
        List<ProductsRes> productsResList = new ArrayList<>();
        List<ProductsEntity> productsEntities = (List<ProductsEntity>) productsRepository.findAll();
        for (int i=0;i<productsEntities.size();i++){
            ProductsRes productsRes = new ProductsRes();
            productsRes.setCategoryId(productsEntities.get(i).getCategoryId());
            productsRes.setName(productsEntities.get(i).getName());
            productsRes.setStock(productsEntities.get(i).getStock());
            productsRes.setPrice(productsEntities.get(i).getPrice());
            productsRes.setDescription(productsEntities.get(i).getDescription());
            productsRes.setId(productsEntities.get(i).getId());
            productsResList.add(productsRes);
        }
        return productsResList;
    }

    public ProductsRes findById(Long id){
        ProductsEntity productsEntity = productsRepository.findById(id).get();
        ProductsRes productsRes = new ProductsRes();
        productsRes.setCategoryId(productsEntity.getCategoryId());
        productsRes.setName(productsEntity.getName());
        productsRes.setStock(productsEntity.getStock());
        productsRes.setPrice(productsEntity.getPrice());
        productsRes.setDescription(productsEntity.getDescription());
        productsRes.setId(productsEntity.getId());
        return productsRes;
    }

    public ProductsEntity findByIdStock(Long id){
        return productsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ไม่พบสินค้า id: " + id));
    }

    public void calculateStock(SellProductReq sellProductReq,Long id){
        ProductsEntity productsEntity = findByIdStock(id);

            if(productsEntity.getStock() > 0){
                System.out.println("จำนวนสินค้า : "+productsEntity.getStock());
                if (sellProductReq.getNumberProduct() > 0) {
                    if (sellProductReq.getMoney().compareTo(BigDecimal.ZERO) > 0) {
                        int newStock = productsEntity.getStock()-sellProductReq.getNumberProduct();
                        productsEntity.setStock(newStock);
                        productsRepository.save(productsEntity);
                    }
                }
            }else {
                System.out.println("จำนวนสินค้าหมด");
            }
        }
    }
