package com.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Cart {

    private Integer CartId;

    private Integer CartCustomerId;

    private String CartBookName;

    private BigDecimal CartBookSellPrice;

    private Integer CartBookCount;

    private Integer CartBookDiscount;

    private BigDecimal CartBookAllprice;


    public Cart() {
    }

    public Cart(Integer cartId, BigDecimal cartBookAllprice) {
        CartId = cartId;
        CartBookAllprice = cartBookAllprice;
    }

    public Cart(Integer cartId, Integer cartBookCount, BigDecimal cartBookAllprice) {
        CartId = cartId;
        CartBookCount = cartBookCount;
        CartBookAllprice = cartBookAllprice;
    }

    public Cart(Integer cartCustomerId, String cartBookName, BigDecimal cartBookSellPrice, Integer cartBookCount, Integer cartBookDiscount, BigDecimal cartBookAllprice) {
        CartCustomerId = cartCustomerId;
        CartBookName = cartBookName;
        CartBookSellPrice = cartBookSellPrice;
        CartBookCount = cartBookCount;
        CartBookDiscount = cartBookDiscount;
        CartBookAllprice = cartBookAllprice;
    }

    public Cart(Integer cartId, Integer cartCustomerId, String cartBookName, BigDecimal cartBookSellPrice, Integer cartBookCount, Integer cartBookDiscount, BigDecimal cartBookAllprice) {
        CartId = cartId;
        CartCustomerId = cartCustomerId;
        CartBookName = cartBookName;
        CartBookSellPrice = cartBookSellPrice;
        CartBookCount = cartBookCount;
        CartBookDiscount = cartBookDiscount;
        CartBookAllprice = cartBookAllprice;
    }
}
