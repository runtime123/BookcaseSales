package com.controller.user.order;

import com.entity.Cart;
import com.entity.Customer;
import com.entity.Order;

import com.entity.OrderDetail;
import com.github.pagehelper.PageInfo;
import com.service.CartService;
import com.service.CustomerService;
import com.service.OrderDetailService;
import com.service.OrderService;
import com.util.OrderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private CartService cartService;


    //查询该用户的所有订单
    @RequestMapping("/orderList")
    public String getOrderByCustomer(HttpServletRequest request){
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer1");
        List<Order> orders = orderService.getOrderByCustomerId(customer.getCustomerId(),1,5);
        PageInfo pageInfo = new PageInfo(orders);
        System.out.println(pageInfo);
        session.setAttribute("orders",pageInfo);
        return "user/orders";
    }

    @RequestMapping("/user/settlement")
    public String toSettlement(){
        return "user/settlement";
    }


    //进入订单结算界面
    @RequestMapping("/orderSettlement")
    public String orderSettlement(@RequestParam("cartBookName") String cartBookName, HttpServletRequest request){
        //生成一个未支付的订单，及相关订单细节
        Customer customer = (Customer) request.getSession().getAttribute("customer1");
        //添加一条订单信息，收货者信息默认为当前登录的用户
        String orderSnid = OrderUtil.getOrderSnid();
        Order order = new Order(orderSnid,customer.getCustomerId(),customer.getCustomerName(),customer.getCustomerPhone(),customer.getCustomerAddress(),new Date(),0);
        orderService.insertOrder(order);
        //获取要结算的购物车信息
        Cart cart = cartService.querySettlementCart(customer.getCustomerId(),cartBookName);
        request.setAttribute("orderCart",cart);
        //添加一条订单细节信息
        OrderDetail orderDetail = new OrderDetail(order.getOrderId(),cart.getCartCustomerId(),cart.getCartBookName(),cart.getCartBookSellPrice(),cart.getCartBookCount(),cart.getCartBookDiscount(),cart.getCartBookAllprice());
        request.setAttribute("orderOrderDetail",orderDetail);
        orderDetailService.insertOrderDetail(orderDetail);

        return "user/settlement";

    }

    @RequestMapping("/toPay")
    public String toPay(){
        return "user/pay";
    }

}

