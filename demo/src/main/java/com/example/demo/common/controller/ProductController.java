package com.example.demo.common.controller;

import com.example.demo.common.dto.ProductRes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.common.dto.ProductReq;
import com.example.demo.common.service.ProductService;

import java.util.List;
@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/create-product")
    public ResponseEntity<Void> create(@RequestBody ProductReq productReq){
        productService.saveProduct(productReq);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/get-allProduct")
    public ResponseEntity<List<ProductRes>> getall()
    {
        List<ProductRes>productResList = productService.findAll();
        return ResponseEntity.ok(productResList);
    }

    @GetMapping("/get-by-idProduct/{id}")
    public ResponseEntity<ProductRes> getById(@PathVariable Long id)
    {
        ProductRes productRes = productService.findById(id);
        return ResponseEntity.ok(productRes);
    }

    @PutMapping("/update")
    public ResponseEntity<ProductRes> update(@RequestBody ProductReq productReq){
        productService.saveProduct(productReq);
        return ResponseEntity.ok().build();
    }
}
//1.entity
//2.repository
//3.dto - Req,Res
//4.Service
//5.Controller
