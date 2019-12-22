package com.service.impl;

import com.dao.OrderDao;
import com.entity.Order;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;


    @Override
    public List<Order> getAllOrderByPage(int pageNum, int pageSize) {
        return orderDao.getAllOrderByPage(pageNum,pageSize);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    @Override
    public List<Order> getOrderByCustomerId(int OrderCustomerId, int pageNum, int pageSize) {
        return orderDao.getOrderByCustomerId(OrderCustomerId, pageNum, pageSize);
    }

    @Override
    public List<Order> getOrderByStatus(int OrderPayStatus, int pageNum, int pageSize) {
        return getOrderByStatus(OrderPayStatus, pageNum, pageSize);
    }



    @Override
    public List<Order> getOrderByOrderId(String OrderSnid) {
        return orderDao.getOrderByOrderId(OrderSnid);
    }

    @Override
    public int insertOrder(Order order) {
        return orderDao.insertOrder(order);
    }

    @Override
    public int updateOrder(int OrderId, int OrderPayStatus) {
        return orderDao.updateOrder(OrderId, OrderPayStatus);
    }
}
