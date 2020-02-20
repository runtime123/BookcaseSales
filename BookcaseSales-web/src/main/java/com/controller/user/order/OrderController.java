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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.soap.DetailEntry;
import java.math.BigDecimal;
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
    public String getOrderByCustomer(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer1");
        List<Order> orders = orderService.getOrderByCustomerId(customer.getCustomerId());
        PageInfo pageInfo = new PageInfo(orders);
        System.out.println(pageInfo);
        model.addAttribute("orders",pageInfo);
        return "user/orders";
    }

    @RequestMapping("/settlement")
    public String toSettlement(){
        return "user/settlement";
    }


    /**
    进入订单结算界面,此时生成一条未结算的订单并显示在结算界面
     */
    @RequestMapping("/orderSettlement")
    public String orderSettlement(String cartBookName, HttpServletRequest request, Model model){
        //System.out.println("===============" + cartBookName);//要购买的书名
        //1、生成一个未支付的订单，及相关订单细节
        //1.1、获取用户信息
        Customer customer = (Customer) request.getSession().getAttribute("customer1");
        //获取要结算的购物车信息，根据用户编号及商品名称
       Cart cart = cartService.querySettlementCart(customer.getCustomerId(),cartBookName);

        /**
         * 添加一条订单信息，收货者信息默认为当前登录的用户
         */
        String orderSnid = OrderUtil.getOrderSnid();
        /**
         * 生成订单对象
         */
        Order order1 = new Order(orderSnid,customer.getCustomerId(),customer.getCustomerName(),customer.getCustomerPhone(),customer.getCustomerAddress(),new Date(),0,null);
        orderService.insertOrder(order1);//生成一条订单
        //添加一条订单细节信息
        Order order2 = orderService.getOrderByOrderSnid(orderSnid);
        OrderDetail orderDetail = new OrderDetail(order2.getOrderId(),cart.getCartCustomerId(),cartBookName,cart.getCartBookSellPrice(),cart.getCartBookCount(),cart.getCartBookDiscount(),cart.getCartBookAllprice());
        orderDetailService.insertOrderDetail(orderDetail);//生成一条订单细节信息

        //生成订单后删除购物车中的这条商品信息
        cartService.deleteOne(cart.getCartCustomerId(),cart.getCartBookName());
        return "user/settlement";

    }

    //根据用户ID查询其订单细节信息，以便于结算
    @RequestMapping("/getOrderDetailByCutomerId")
    public String getOrderDetailByCutomerId(Model model,HttpServletRequest request){
        Customer customer = (Customer) request.getSession().getAttribute("customer1");

        List<OrderDetail> orderDetails = orderDetailService.getDetailOrderByCustomerId(customer.getCustomerId());
        //request.setAttribute("od",orderDetails);
        model.addAttribute("od",orderDetails);
        return "user/settlement";
    }



    //根据订单ID删除订单
    @RequestMapping("/deleteOrderAndDetailOne")
    public String deleteOrderAndDetail(@RequestParam(value = "orderId",required = false) int orderId){
            orderService.deleteOrderOneByOrderId(orderId);
            orderDetailService.deleteDetailOrderOneByDetailOrderId(orderId);
            return "user/orders";
    }

}

