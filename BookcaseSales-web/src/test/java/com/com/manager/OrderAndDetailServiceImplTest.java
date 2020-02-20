package com.com.manager;

import com.entity.Order;
import com.entity.OrderDetail;
import com.service.OrderDetailService;
import com.service.OrderService;
import config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class OrderAndDetailServiceImplTest {
    @Autowired
    private OrderService orderService;
    @Autowired
    private  OrderDetailService orderDetailService;

    @Test
    public void testGetAllOrder() {
        List<Order> orderList = orderService.getAllOrderAndDetailBym(1,6);
        for (Order order : orderList) {
            System.out.println(order.getOrderCreateAt());
        }
    }

    @Test
    public void updateOrder() {


        Order order = new Order(75,"75667e1b-d6ae-425a-a834-36c894d051e1",4,"苏尘","18370014964","江苏省苏州市我是仙凡界", Date.valueOf("2020-02-01"),0,new java.util.Date());
        orderService.updateOrderAll(order);
    }

    @Test
    public void updateOrderDetail() {
        OrderDetail orderDetail = new OrderDetail(54,	75,	4,"《邓小平时代》", BigDecimal.valueOf(1000.00),1,10,BigDecimal.valueOf(1000.00));
        orderDetailService.updateOrderDetail(orderDetail);
    }

    //查询某条订单及其信息
    @Test
    public void queryOne() {
        Order order = orderService.getOrderByOrderIdm(75);
        System.out.println();
    }

    //查询某条订单及其细节信息
    @Test
    public void queryOrderAndDetail() {
        Order order = orderService.getOneOrderByOrderId(75);
        OrderDetail orderDetail = orderDetailService.getOneOrderDetail(75);
        System.out.println("-----------" + orderDetail.getDetailId());
    }
}
