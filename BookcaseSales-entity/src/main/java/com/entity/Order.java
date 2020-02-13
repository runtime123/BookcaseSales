package com.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Order {
    //订单ID
    private Integer OrderId;
    //订单编号
    private String OrderSnid;
    //用户ID
    private Integer OrderCustomerId;
    //收货人
    private String OrderReciver;
    //收货人手机号码
    private String OrderPhone;
    //收货地址
    private String OrderAddr;

    //订单创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date OrderCreateAt;
    //支付状态
    private Integer OrderPayStatus;
    //最后一次修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date OrderLastCreateAt;
    //订单细节信息
    private List<OrderDetail> orderDetails;



    public Order() {
    }

    public Order(Integer orderId, String orderSnid, Integer orderCustomerId, String orderReciver, String orderPhone, String orderAddr, Date orderCreateAt, Integer orderPayStatus, Date orderLastCreateAt) {
        OrderId = orderId;
        OrderSnid = orderSnid;
        OrderCustomerId = orderCustomerId;
        OrderReciver = orderReciver;
        OrderPhone = orderPhone;
        OrderAddr = orderAddr;
        OrderCreateAt = orderCreateAt;
        OrderPayStatus = orderPayStatus;
        OrderLastCreateAt = orderLastCreateAt;
    }

    public Order(String orderSnid, Integer orderCustomerId, String orderReciver, String orderPhone, String orderAddr, Date orderCreateAt, Integer orderPayStatus, Date orderLastCreateAt) {
        OrderSnid = orderSnid;
        OrderCustomerId = orderCustomerId;
        OrderReciver = orderReciver;
        OrderPhone = orderPhone;
        OrderAddr = orderAddr;
        OrderCreateAt = orderCreateAt;
        OrderPayStatus = orderPayStatus;
        OrderLastCreateAt = orderLastCreateAt;
    }

    public Order(Integer orderId, String orderSnid, Integer orderCustomerId, String orderReciver, String orderPhone, String orderAddr, Date orderCreateAt, Integer orderPayStatus, Date orderLastCreateAt, List<OrderDetail> orderDetails) {
        OrderId = orderId;
        OrderSnid = orderSnid;
        OrderCustomerId = orderCustomerId;
        OrderReciver = orderReciver;
        OrderPhone = orderPhone;
        OrderAddr = orderAddr;
        OrderCreateAt = orderCreateAt;
        OrderPayStatus = orderPayStatus;
        OrderLastCreateAt = orderLastCreateAt;
        this.orderDetails = orderDetails;
    }

    public Order(String orderSnid, Integer orderCustomerId, String orderReciver, String orderPhone, String orderAddr, Date orderCreateAt, Integer orderPayStatus, Date orderLastCreateAt, List<OrderDetail> orderDetails) {
        OrderSnid = orderSnid;
        OrderCustomerId = orderCustomerId;
        OrderReciver = orderReciver;
        OrderPhone = orderPhone;
        OrderAddr = orderAddr;
        OrderCreateAt = orderCreateAt;
        OrderPayStatus = orderPayStatus;
        OrderLastCreateAt = orderLastCreateAt;
        this.orderDetails = orderDetails;
    }

    public Integer getOrderId() {
        return OrderId;
    }

    public void setOrderId(Integer orderId) {
        OrderId = orderId;
    }

    public String getOrderSnid() {
        return OrderSnid;
    }

    public void setOrderSnid(String orderSnid) {
        OrderSnid = orderSnid;
    }

    public Integer getOrderCustomerId() {
        return OrderCustomerId;
    }

    public void setOrderCustomerId(Integer orderCustomerId) {
        OrderCustomerId = orderCustomerId;
    }

    public String getOrderReciver() {
        return OrderReciver;
    }

    public void setOrderReciver(String orderReciver) {
        OrderReciver = orderReciver;
    }

    public String getOrderPhone() {
        return OrderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        OrderPhone = orderPhone;
    }

    public String getOrderAddr() {
        return OrderAddr;
    }

    public void setOrderAddr(String orderAddr) {
        OrderAddr = orderAddr;
    }

    public Date getOrderCreateAt() {
        return OrderCreateAt;
    }

    public void setOrderCreateAt(Date orderCreateAt) {
        OrderCreateAt = orderCreateAt;
    }

    public Integer getOrderPayStatus() {
        return OrderPayStatus;
    }

    public void setOrderPayStatus(Integer orderPayStatus) {
        OrderPayStatus = orderPayStatus;
    }

    public Date getOrderLastCreateAt() {
        return OrderLastCreateAt;
    }

    public void setOrderLastCreateAt(Date orderLastCreateAt) {
        OrderLastCreateAt = orderLastCreateAt;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Order{" +
                "OrderId=" + OrderId +
                ", OrderSnid='" + OrderSnid + '\'' +
                ", OrderCustomerId=" + OrderCustomerId +
                ", OrderReciver='" + OrderReciver + '\'' +
                ", OrderPhone='" + OrderPhone + '\'' +
                ", OrderAddr='" + OrderAddr + '\'' +
                ", OrderCreateAt=" + OrderCreateAt +
                ", OrderPayStatus=" + OrderPayStatus +
                ", OrderLastCreateAt=" + OrderLastCreateAt +
                ", orderDetails=" + orderDetails +
                '}';
    }
}

