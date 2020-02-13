package com.service.impl;

import com.dao.OrderDao;
import com.entity.Order;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public List<Order> getOrderByCustomerId(int OrderCustomerId) {
        return orderDao.getOrderByCustomerId(OrderCustomerId);
    }


    @Override
    public List<Order> getOrderByStatus(int OrderPayStatus, int pageNum, int pageSize) {
        return orderDao.getOrderByStatus(OrderPayStatus, pageNum, pageSize);
    }


    @Override
    public Order getOrderByOrderSnid(String OrderSnid) {
        return orderDao.getOrderByOrderSnid(OrderSnid);
    }

    @Override
    public int insertOrder(Order order) {
        return orderDao.insertOrder(order);
    }

    @Override
    public int updateOrder(int OrderId, int OrderPayStatus, Date OrderLastCreateAt) {
        return orderDao.updateOrder(OrderId, OrderPayStatus,OrderLastCreateAt);
    }

    @Override
    public int deleteOrderOneByOrderId(int orderId) {
        return orderDao.deleteOrderOneByOrderId(orderId);
    }

    @Override
    public List<Order> getAllOrderAndDetailBym(int pageNum, int pageSize) {
        return orderDao.getAllOrderAndDetailBym(pageNum,pageSize);
    }

    @Override
    public int updateOrderAll(Order order) {
        return orderDao.updateOrderAll(order);
    }

    @Override
    public Order getOrderByOrderIdm(int orderId) {
        return orderDao.getOrderByOrderIdm(orderId);
    }
}
