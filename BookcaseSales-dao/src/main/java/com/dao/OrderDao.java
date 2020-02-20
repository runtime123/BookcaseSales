package com.dao;


import com.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface OrderDao {

    //分页查询所有订单信息
    List<Order> getAllOrderByPage(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
    //查询所有订单信息
    List<Order> getAllOrders();
    //根据用户编号获取所有订单信息
    List<Order> getOrderByCustomerId(int OrderCustomerId);
    //根据订单状态分页获取所有订单信息
    List<Order> getOrderByStatus(int OrderPayStatus,@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
    //根据订单编号获取订单信息
    Order getOrderByOrderSnid(String OrderSnid);
    //添加订单信息
    int insertOrder(Order order);
    //修改订单信息
    int updateOrder(int OrderId, int OrderPayStatus, Date OrderLastCreateAt);

    //根据订单ID删除订单
    int deleteOrderOneByOrderId(int orderId);

    //分页查询所有订单信息
    List<Order> getAllOrderAndDetailBym(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);

    //根据订单编号删除订单信息
    int updateOrderAll(Order order);

    //查询某条订单及其信息
    Order getOrderByOrderIdm(int orderId);
    //查询某条订单信息
    Order getOneOrderByOrderId(int orderId);

}
