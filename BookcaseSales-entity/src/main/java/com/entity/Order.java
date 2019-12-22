package com.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class Order {
    private Integer OrderId;//订单ID
    private String OrderSnid;//订单编号
    private Integer OrderCustomerId;//用户ID
    private String OrderReciver;//收货人
    private String OrderPhone;//收货人手机号码
    private String OrderAddr;//收货地址
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date OrderCreateAt;//订单创建时间
    private Integer OrderPayStatus;//支付状态
    //订单细节信息
    private List<OrderDetail> orderDetails;


    public Integer getOrderId() {
        return OrderId;
    }

    public Order() {
    }

    public Order(String orderSnid, Integer orderCustomerId, String orderReciver, String orderPhone, String orderAddr, Date orderCreateAt, Integer orderPayStatus) {
        OrderSnid = orderSnid;
        OrderCustomerId = orderCustomerId;
        OrderReciver = orderReciver;
        OrderPhone = orderPhone;
        OrderAddr = orderAddr;
        OrderCreateAt = orderCreateAt;
        OrderPayStatus = orderPayStatus;
    }

    public Order(Integer orderId, String orderSnid, Integer orderCustomerId, String orderReciver, String orderPhone, String orderAddr, Date orderCreateAt, Integer orderPayStatus) {
        OrderId = orderId;
        OrderSnid = orderSnid;
        OrderCustomerId = orderCustomerId;
        OrderReciver = orderReciver;
        OrderPhone = orderPhone;
        OrderAddr = orderAddr;
        OrderCreateAt = orderCreateAt;
        OrderPayStatus = orderPayStatus;
    }
}
