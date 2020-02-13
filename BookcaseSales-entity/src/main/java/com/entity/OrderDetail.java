package com.entity;

import lombok.Data;

import java.math.BigDecimal;


public class OrderDetail {

    private Integer DetailId;//订单细节ID
    private Integer DetailOrderId;//订单ID
    private Integer DetailCustomerId;//下单的用户ID
    private String DetailBookName;//图书名称
    private BigDecimal DetailBookPrice;//图书单价
    private Integer DetailBookAmount;//图书数量
    private Integer DetailBookDiscount;//价格折扣
    private BigDecimal DetailTotalMoney;//图书总价=数量*单价*折扣

    public OrderDetail() {
    }

    public OrderDetail(Integer detailOrderId, Integer detailCustomerId, String detailBookName, BigDecimal detailBookPrice, Integer detailBookAmount, Integer detailBookDiscount, BigDecimal detailTotalMoney) {
        DetailOrderId = detailOrderId;
        DetailCustomerId = detailCustomerId;
        DetailBookName = detailBookName;
        DetailBookPrice = detailBookPrice;
        DetailBookAmount = detailBookAmount;
        DetailBookDiscount = detailBookDiscount;
        DetailTotalMoney = detailTotalMoney;
    }

    public OrderDetail(Integer detailId, Integer detailOrderId, Integer detailCustomerId, String detailBookName, BigDecimal detailBookPrice, Integer detailBookAmount, Integer detailBookDiscount, BigDecimal detailTotalMoney) {
        DetailId = detailId;
        DetailOrderId = detailOrderId;
        DetailCustomerId = detailCustomerId;
        DetailBookName = detailBookName;
        DetailBookPrice = detailBookPrice;
        DetailBookAmount = detailBookAmount;
        DetailBookDiscount = detailBookDiscount;
        DetailTotalMoney = detailTotalMoney;
    }

    public Integer getDetailId() {
        return DetailId;
    }

    public void setDetailId(Integer detailId) {
        DetailId = detailId;
    }

    public Integer getDetailOrderId() {
        return DetailOrderId;
    }

    public void setDetailOrderId(Integer detailOrderId) {
        DetailOrderId = detailOrderId;
    }

    public Integer getDetailCustomerId() {
        return DetailCustomerId;
    }

    public void setDetailCustomerId(Integer detailCustomerId) {
        DetailCustomerId = detailCustomerId;
    }

    public String getDetailBookName() {
        return DetailBookName;
    }

    public void setDetailBookName(String detailBookName) {
        DetailBookName = detailBookName;
    }

    public BigDecimal getDetailBookPrice() {
        return DetailBookPrice;
    }

    public void setDetailBookPrice(BigDecimal detailBookPrice) {
        DetailBookPrice = detailBookPrice;
    }

    public Integer getDetailBookAmount() {
        return DetailBookAmount;
    }

    public void setDetailBookAmount(Integer detailBookAmount) {
        DetailBookAmount = detailBookAmount;
    }

    public Integer getDetailBookDiscount() {
        return DetailBookDiscount;
    }

    public void setDetailBookDiscount(Integer detailBookDiscount) {
        DetailBookDiscount = detailBookDiscount;
    }

    public BigDecimal getDetailTotalMoney() {
        return DetailTotalMoney;
    }

    public void setDetailTotalMoney(BigDecimal detailTotalMoney) {
        DetailTotalMoney = detailTotalMoney;
    }


    @Override
    public String toString() {
        return "OrderDetail{" +
                "DetailId=" + DetailId +
                ", DetailOrderId=" + DetailOrderId +
                ", DetailCustomerId=" + DetailCustomerId +
                ", DetailBookName='" + DetailBookName + '\'' +
                ", DetailBookPrice=" + DetailBookPrice +
                ", DetailBookAmount=" + DetailBookAmount +
                ", DetailBookDiscount=" + DetailBookDiscount +
                ", DetailTotalMoney=" + DetailTotalMoney +
                '}';
    }
}
