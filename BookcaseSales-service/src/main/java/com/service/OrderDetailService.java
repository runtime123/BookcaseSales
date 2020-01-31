package com.service;

import com.entity.OrderDetail;

import java.util.List;

public interface OrderDetailService {

    List<OrderDetail> getAllOrderDetail(int DetailOrderId);

    int insertOrderDetail(OrderDetail orderDetail);

    //根据用户Id获取订单细节信息
    List<OrderDetail> getDetailOrderByCustomerId(int customerId);
}
