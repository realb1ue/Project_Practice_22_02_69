package com.example.demo.common.service;

import com.example.demo.common.dto.ProductReq;
import com.example.demo.common.dto.ProductRes;
import com.example.demo.common.entity.Productentity;
import com.example.demo.common.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public void saveProduct(ProductReq productReq){
        Productentity productentity = new Productentity();

        productentity.setProductCode(productReq.getProductCode());
        productentity.setProductName(productReq.getProductName());
        productentity.setPrice(productReq.getPrice());
        productentity.setStock(productReq.getStock());
        productentity.setStatus(productReq.getStatus());

        productRepository.save(productentity);
    }
    public List<ProductRes> findAll(){
        List<ProductRes> productResList = new ArrayList<>();
        List<Productentity> productentities = (List<Productentity>) productRepository.findAll();
        for (int i = 0; i< productentities.size(); i++){
            ProductRes productRes = new ProductRes();
            productRes.setProductCode(productentities.get(i).getProductCode());
            productRes.setProductName(productentities.get(i).getProductName());
            productRes.setPrice(productentities.get(i).getPrice());
            productRes.setStock(productentities.get(i).getStock());
            productRes.setStatus(productentities.get(i).getStatus());
            productResList.add(productRes);
        }
        return productResList;
    }
    public ProductRes findById(Long id){
        Productentity productentity = productRepository.findById(id).get();
        ProductRes productRes = new ProductRes();
        productRes.setProductCode(productentity.getProductCode());
        productRes.setProductName(productentity.getProductName());
        productRes.setPrice(productentity.getPrice());
        productRes.setStock(productentity.getStock());
        productRes.setStatus(productentity.getStatus());
        return productRes;
    }
    public void update(ProductReq productReqq){
        Productentity productentity = productRepository.findById(productReqq.getId()).get();
        productentity.setProductCode(productReqq.getProductCode());
        productentity.setProductName(productReqq.getProductName());
        productentity.setPrice(productReqq.getPrice());
        productentity.setStock(productReqq.getStock());
        productentity.setStatus(productReqq.getStatus());

        productRepository.save(productentity);
        }

}

