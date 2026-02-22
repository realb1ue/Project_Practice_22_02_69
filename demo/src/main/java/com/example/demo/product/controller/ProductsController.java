package com.example.demo.product.controller;


import com.example.demo.common.dto.ProductReq;
import com.example.demo.common.dto.ProductRes;
import com.example.demo.common.service.ProductService;
import com.example.demo.product.dto.ProductsReq;
import com.example.demo.product.dto.ProductsRes;
import com.example.demo.product.dto.SellProductReq;
import com.example.demo.product.service.ProductsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private final ProductsService productsService;

    public ProductsController(ProductsService productsService){
        this.productsService = productsService;
    }

    @RequestMapping("/create")
    public ResponseEntity createProducts(@RequestBody ProductsReq productsReq){
        productsService.saveProducts(productsReq);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<ProductsRes>> getall()
    {
        List<ProductsRes> productsResList = productsService.findAll();
        return ResponseEntity.ok(productsResList);
    }

   @PostMapping("/sell-product/{id}")
    public ResponseEntity<Void> calculateStock(@RequestBody SellProductReq sellProductReq,@PathVariable Long id){
       productsService.calculateStock(sellProductReq,id);
        return ResponseEntity.ok().build();
   }

    @GetMapping("/find-id/{id}")
    public ResponseEntity<ProductsRes> findById(@PathVariable Long id)
    {
        ProductsRes productsRes = productsService.findById(id);
        return ResponseEntity.ok(productsRes);
    }


}
