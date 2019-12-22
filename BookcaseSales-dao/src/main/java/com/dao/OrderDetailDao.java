package com.dao;

import com.entity.OrderDetail;

import java.util.List;

public interface OrderDetailDao {

    List<OrderDetail> getAllOrderDetail(int DetailOrderId);

    int insertOrderDetail(OrderDetail orderDetail);

}
