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

    @Override
    public List<OrderDetail> getDetailOrderByCustomerId(int customerId) {
        return orderDetailDao.getDetailOrderByCustomerId(customerId);
    }

    @Override
    public int deleteDetailOrderOneByDetailOrderId(int detailOrderId) {
        return orderDetailDao.deleteDetailOrderOneByDetailOrderId(detailOrderId);
    }

    @Override
    public int updateOrderDetail(OrderDetail orderDetail) {
        return orderDetailDao.updateOrderDetail(orderDetail);
    }

    @Override
    public OrderDetail getOneOrderDetail(int detailOrderId) {
        return orderDetailDao.getOneOrderDetail(detailOrderId);
    }
}
