package com.service;

import com.entity.OrderDetail;

import java.util.List;

public interface OrderDetailService {

    List<OrderDetail> getAllOrderDetail(int DetailOrderId);

    int insertOrderDetail(OrderDetail orderDetail);
}
