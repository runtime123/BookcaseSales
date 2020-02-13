package com.service;

import com.entity.OrderDetail;

import java.util.List;

public interface OrderDetailService {

    List<OrderDetail> getAllOrderDetail(int DetailOrderId);

    int insertOrderDetail(OrderDetail orderDetail);

    //根据用户Id获取订单细节信息
    List<OrderDetail> getDetailOrderByCustomerId(int customerId);

    //根据订单ID算出订单细节信息
    int deleteDetailOrderOneByDetailOrderId(int detailOrderId);
    //修改订单细节信息
    int updateOrderDetail(OrderDetail orderDetail);
}
