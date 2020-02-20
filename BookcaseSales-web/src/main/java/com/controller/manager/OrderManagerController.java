package com.controller.manager;

import com.entity.Order;
import com.entity.OrderDetail;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
import com.service.OrderDetailService;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 管理员使用的订单管理界面
 */
@Controller
@RequestMapping("/m/orderAndDetail")
public class OrderManagerController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;



    /**
     * 分页查询所有订单
     */
    @RequestMapping("/getAllOrderAndDetailByPage")
    public String getAllOrderAndDetailByPage(@RequestParam(value = "pageNum", defaultValue = "1", required = false) int pageNum,
                                             @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize
            , Model model) {
        List<Order> orders = orderService.getAllOrderAndDetailBym(pageNum, pageSize);
        PageInfo orderList = new PageInfo(orders);
        model.addAttribute("orderList", orderList);
        return "manager/order/orderAndDetailManager";
    }


    /**
     * 根据订但ID得到一条订单及其细节信息
     * 进入修改订单信息界面修改订单信息
     */
    @RequestMapping("/toUpdateJsp")
    public String updateOrder(@RequestParam(value = "orderId",required = false) int orderId,Model model) {
        Order order = orderService.getOneOrderByOrderId(orderId);
        OrderDetail orderDetail = orderDetailService.getOneOrderDetail(orderId);
        model.addAttribute("mOrderToUpdate",order);
        model.addAttribute("mOrderDetailToUpdate",orderDetail);
        return "manager/order/updateOrderAndDetail";
    }

    /**
     * 在修改页面修改订单细节信息
     */
    @RequestMapping("/doUpdateOrderDetail")
    public String updateOrder(@RequestBody OrderDetail orderDetail){
        System.out.println("666666666666666666666666666666" + orderDetail);
        orderDetailService.updateOrderDetail(orderDetail);
        return "manager/order/orderAndDetailManager";
    }

    /**
     * 在修改页面修改订单信息
     */
    @RequestMapping("/doUpdateOrder")
    public String updateOrder(@RequestBody Order order){
        ;
        orderService.updateOrderAll(order);
        return "manager/order/orderAndDetailManager";
    }


    /**
     * 删除订单
     * @param orderId
     * @return
     */
    @RequestMapping("/deleteOrder")
    public String delete(@RequestParam(value = "orderId",required = false) int orderId){
        orderService.deleteOrderOneByOrderId(orderId);
        orderDetailService.deleteDetailOrderOneByDetailOrderId(orderId);
        return "manager/order/orderAndDetailManager";
    }
}
