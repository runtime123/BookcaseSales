package com.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDetail {
    private Integer DetailId;//订单细节ID
    private Integer DetailOrderId;//订单ID
    private Integer DetailBookId;//图书ID
    private String DetailBookName;//图书名称
    private BigDecimal DetailBookPrice;//图书单价
    private Integer DetailBookAmount;//图书数量
    private Integer DetailBookDiscount;//价格折扣
    private BigDecimal DetailTotalMoney;//图书总价=数量*单价*折扣

    public OrderDetail() {
    }

    public OrderDetail(Integer detailOrderId, Integer detailBookId, String detailBookName, BigDecimal detailBookPrice, Integer detailBookAmount, Integer detailBookDiscount, BigDecimal detailTotalMoney) {
        DetailOrderId = detailOrderId;
        DetailBookId = detailBookId;
        DetailBookName = detailBookName;
        DetailBookPrice = detailBookPrice;
        DetailBookAmount = detailBookAmount;
        DetailBookDiscount = detailBookDiscount;
        DetailTotalMoney = detailTotalMoney;
    }

    public OrderDetail(Integer detailId, Integer detailOrderId, Integer detailBookId, String detailBookName, BigDecimal detailBookPrice, Integer detailBookAmount, Integer detailBookDiscount, BigDecimal detailTotalMoney) {
        DetailId = detailId;
        DetailOrderId = detailOrderId;
        DetailBookId = detailBookId;
        DetailBookName = detailBookName;
        DetailBookPrice = detailBookPrice;
        DetailBookAmount = detailBookAmount;
        DetailBookDiscount = detailBookDiscount;
        DetailTotalMoney = detailTotalMoney;
    }
}
