package com.com.user;

import com.entity.Order;
import com.entity.OrderDetail;
import com.service.OrderDetailService;
import com.service.OrderService;
import com.util.OrderUtil;
import config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class OrderAndDetailServiceImplTest {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;

    /**
     * 测试订单查询
     */
    @Test
    public void testOrderQuery(){
        List<Order> orders = orderService.getOrderByCustomerId(5);

        for (Order order : orders) {
            System.out.println("+++++++++" + order.getOrderDetails());
        }
    }



    /*
     *测试添加订单和订单细节
     */
    @Test
    public void testInsert(){
        String snid = OrderUtil.getOrderSnid();
        Order order = new Order(snid,9,"陈川","18370014967","四川省成都市洪荒封神界",BigDecimal.valueOf(100),new Date(),0,new Date());
        int result1 = orderService.insertOrder(order);
        Order order2 = orderService.getOrderByOrderSnid(snid);
        Integer detailOrderId = order2.getOrderId();
        System.out.println(order2);
        OrderDetail orderDetail = new OrderDetail(detailOrderId,9,"《吞噬星空》",BigDecimal.valueOf(100),4,10,BigDecimal.valueOf(400));
        System.out.println(orderDetail);
        int resutl2 = orderDetailService.insertOrderDetail(orderDetail);
        System.out.println("------------------------------------" + result1 + "/n " +
                "-----------------------------------------" + resutl2);

    }

    //根据订单ID删除订单信息和订单细节信息
    @Test
    public void testDeleteOrderAndDetailOrder() {
        int id = 72;
        orderService.deleteOrderOneByOrderId(id);
        orderDetailService.deleteDetailOrderOneByDetailOrderId(id);
    }
}
