package com.service.impl;

import com.dao.OrderDetailDao;
import com.entity.OrderDetail;
import com.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    public List<OrderDetail> getAllOrderDetail(int DetailOrderId) {
        return orderDetailDao.getAllOrderDetail(DetailOrderId);
    }

    @Override
    public int insertOrderDetail(OrderDetail orderDetail) {
        return orderDetailDao.insertOrderDetail(orderDetail);
    }
}
