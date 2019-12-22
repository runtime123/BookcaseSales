package com.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Cart {

    private Integer CartCustomerId;

    private String CartBookName;

    private BigDecimal CartBookSellPrice;

    private Integer CartBookCount;

    private Integer CartBookDiscount;

    private BigDecimal CartBookAllprice;

    public Integer getCartCustomerId() {
        return CartCustomerId;
    }

    public BigDecimal getCartBookSellPrice() {
        return CartBookSellPrice;
    }

    public Integer getCartBookDiscount() {
        return CartBookDiscount;
    }

    public BigDecimal getCartBookAllprice() {
        return CartBookAllprice;
    }

    public String getCartBookName() {
        return CartBookName;
    }

    public Integer getCartBookCount() {
        return CartBookCount;
    }

    public Cart() {
    }

    public Cart(Integer cartCustomerId, String cartBookName, BigDecimal cartBookSellPrice, Integer cartBookCount, Integer cartBookDiscount, BigDecimal cartBookAllprice) {
        CartCustomerId = cartCustomerId;
        CartBookName = cartBookName;
        CartBookSellPrice = cartBookSellPrice;
        CartBookCount = cartBookCount;
        CartBookDiscount = cartBookDiscount;
        CartBookAllprice = cartBookAllprice;
    }


}
