package com.controller.user.cart;


import com.alibaba.druid.support.json.JSONUtils;
import com.entity.Cart;
import com.entity.Customer;
import com.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class CartManager {
    @Autowired
    private CartService cartService;

    /**
     * 前往购物车界面
     * @return
     */
    @RequestMapping("/gouwuche")
    public String toCartJsp(){
        return "user/cart";
    }

    /**
     * 查询该用户的购物车中的所有信息
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/getCart")
    public String getCart(HttpServletRequest request, Model model){
        //获得登录的用户的信息
        Customer customer = (Customer) request.getSession().getAttribute("customer1");
        //通过获得的用户的编号来查询相对应的购物车信息
        List<Cart> cart = cartService.getCartByCustomerId(customer.getCustomerId());
        request.setAttribute("cart",cart);
        System.out.println("购物车" + cart);

        //转发到购物车界面
        return "user/cart";
    }


    /**
     * 首页-如果购物车为空，添加该商品信息
     * @param CartBookName
     * @param CartBookSellPrice
     * @param CartBookDiscount
     * @param request
     * @return
     */
    @RequestMapping("/getCartAdd")
    @ResponseBody
    public String getCartAdd(@RequestParam(value = "CartBookName",required = false) String CartBookName,
                             @RequestParam(value = "CartBookSellPrice",required = false)String CartBookSellPrice,
                             @RequestParam(value = "CartBookDiscount",required = false) String CartBookDiscount,
                             HttpServletRequest request){
        String url = "";

        Customer customer1 = (Customer) request.getSession().getAttribute("customer1");

        //单价
        BigDecimal price = new BigDecimal(CartBookSellPrice);
        //折扣
        Integer discount = Integer.parseInt(CartBookDiscount);
        //总价
        BigDecimal allMoney = new BigDecimal(Double.valueOf(CartBookSellPrice)*Double.valueOf(CartBookDiscount)/10);
        Cart cart1 = new Cart(customer1.getCustomerId(),CartBookName,price,1,discount,allMoney);
        //加入购物车
        int result = cartService.addCartNull(cart1);
        if (result >0) {
            System.out.println("添加成功！");
            request.setAttribute("cart",cartService.getCartByCustomerId(customer1.getCustomerId()));
            url = "user/userIndex";
        }


        return url;
    }

    /**
     * 商品数量+1
     * @param CartBookName
     * @return
     */
    @RequestMapping("/add")
    public String add(@RequestParam(value = "CartBookName",required = false) String CartBookName){
        cartService.updateCountAdd(1,CartBookName);
        return "user/cart";
    }

    /**
     * 购物车中商品数量-1
     * @param CartBookName
     * @return
     */
    @RequestMapping("/sub")
    public String sub(@RequestParam(value = "CartBookName",required = false) String CartBookName){
        cartService.updateCountSub(1,CartBookName);
        return "user/cart";
    }

    /**
     * 删除一条购物车数据
     * @param request
     * @param CartBookName
     * @return
     */
    @RequestMapping("/deleteOne")
    public String deleteOne(HttpServletRequest request,@RequestParam(value = "CartBookName",required = false) String CartBookName){
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer1");
        System.out.println("删除用户编号为"+customer.getCustomerId()+",书名为"+CartBookName+"所有商品");
        int CartCustomerId = customer.getCustomerId();
        System.out.println(CartCustomerId);
        cartService.deleteOne(CartCustomerId,CartBookName);
        return "user/cart";
    }

    /**
     * 清空购物车
     * @param request
     * @return
     */
    @RequestMapping("/deleteAll")
    public String deleteAll(HttpServletRequest request){
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer1");
        System.out.println("删除用户编号为"+customer.getCustomerId()+"的所有商品");
        cartService.deleteByCartCustomerId(customer.getCustomerId());
        return "user/cart";
    }


    /**
     * 商品详情-加入购物车
     * @param cartBookName
     * @param cartBookSellPrice
     * @param cartBookCount
     * @param cartBookDiscount
     * @param cartBookAllprice
     * @param request
     * @return
     */
    @RequestMapping("/addCartBybookDetailJsp")
    public String addCart(@RequestParam(value = "cartBookName",required = false) String cartBookName,
                          @RequestParam(value = "cartBookSellPrice",required = false) String cartBookSellPrice,
                          @RequestParam(value = "cartBookCount",required = false) Integer cartBookCount,
                          @RequestParam(value = "cartBookDiscount",required = false) Integer cartBookDiscount,
                          @RequestParam(value = "cartBookAllprice",required = false) Integer cartBookAllprice,
                          HttpServletRequest request){
       //获取此用户信息
        Customer customer = (Customer) request.getSession().getAttribute("customer1");
        //价格数据类型转换
        BigDecimal bookSellPrice = BigDecimal.valueOf(Long.parseLong(cartBookSellPrice));
        //总价
        BigDecimal cartBookAllprices = BigDecimal.valueOf(cartBookAllprice);
        //要添加的购物车信息
        Cart cart = new Cart(customer.getCustomerId(),cartBookName,bookSellPrice,cartBookCount,cartBookDiscount,cartBookAllprices);
        //输出所有要添加的商品信息
        System.out.println("要添加的购物车信息：" + cart);
        //根据用户编号及图书名称查询其购物车信息
        List<Cart> ucart = cartService.getCartByCustomerIdAndCartBookName(customer.getCustomerId(),cartBookName);
        //显示当前用户购物车中的信息
        System.out.println("用户的购物车：" + ucart);
        //显示当前用户信息
        System.out.println("用户信息："+customer);
        /*
         *判断购物车本书信息是否存在，从而决定添加购物车的方法
         *null判断是判断有没有对list集合分配内存空间,而不是list里面内容是否为空
         *这里用list.isEmpty()或 list.size() == 0两种方法来判断
         */
        if (ucart.size() == 0){
            cartService.addCartNull(cart);
            System.out.println("执行本次操作之前，该用户要购买的此类商品购物车为空");

        } else{
            cartService.updateCountAdd(cartBookCount,cartBookName);
            System.out.println("执行本次操作之前，该用户要购买的此类商品不为空");
        }

        return "redirect:shouye";
    }


}
