package com.example.demo.product.dto;

import java.math.BigDecimal;

public class SellProductReq {
    private BigDecimal money;
    private Integer numberProduct;
    private String nameProduct;

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getNumberProduct() {
        return numberProduct;
    }

    public void setNumberProduct(Integer numberProduct) {
        this.numberProduct = numberProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
}
