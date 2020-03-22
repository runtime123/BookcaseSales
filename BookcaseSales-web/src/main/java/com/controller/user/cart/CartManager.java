package com.controller.user.cart;


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

    //查询该用户的购物车中的所有信息
    @RequestMapping("/getCart")
    public String getCart(HttpServletRequest request, Model model){
        //获得登录的用户的信息
        Customer customer = (Customer) request.getSession().getAttribute("customer1");
        //通过获得的用户的编号来查询相对应的购物车信息
        List<Cart> cart = cartService.getCartByCustomerId(customer.getCustomerId());
        request.setAttribute("cart",cart);
        System.out.println("购物车" + cart);

        //重定向到购物车界面
        return "user/cart";
    }



    //首页-如果购物车为空，添加该商品信息
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
        System.out.println("一一一一一一一一一一一一" + allMoney);
        Cart cart1 = new Cart(customer1.getCustomerId(),CartBookName,price,1,discount,allMoney);

            int result = cartService.addCartNull(cart1);
            if (result >0) {
                System.out.println("添加成功！");
                request.setAttribute("cart",cartService.getCartByCustomerId(customer1.getCustomerId()));
                url = "user/userIndex";
            }
        return url;
    }

    //商品数量+1
    @RequestMapping("/add")
    public String add(@RequestParam(value = "CartBookName",required = false) String CartBookName){
        cartService.updateCountAdd(1,CartBookName);
        return "user/cart";
    }

    //购物车中商品数量-1
    @RequestMapping("/sub")
    public String sub(@RequestParam(value = "CartBookName",required = false) String CartBookName){
        cartService.updateCountSub(1,CartBookName);
        return "user/cart";
    }

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

    @RequestMapping("/deleteAll")
    public String deleteAll(HttpServletRequest request){
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer1");
        System.out.println("删除用户编号为"+customer.getCustomerId()+"的所有商品");
        cartService.deleteByCartCustomerId(customer.getCustomerId());
        return "user/cart";
    }

    /*商品详情-加入购物车*/
    @RequestMapping("/addCartBybookDetailJsp")
    public String addCart(@RequestParam(value = "cartBookName",required = false) String cartBookName,
                          @RequestParam(value = "cartBookSellPrice",required = false) String cartBookSellPrice,
                          @RequestParam(value = "cartBookCount",required = false) Integer cartBookCount,
                          @RequestParam(value = "cartBookDiscount",required = false) Integer cartBookDiscount,
                          @RequestParam(value = "cartBookAllprice",required = false) Integer cartBookAllprice,
                          HttpServletRequest request){
       //获取此用户信息
        Customer customer = (Customer) request.getSession().getAttribute("customer1");
        BigDecimal bookSellPrice = BigDecimal.valueOf(Long.parseLong(cartBookSellPrice));
        //总价
        BigDecimal cartBookAllprices = BigDecimal.valueOf(cartBookAllprice);
        Cart cart = new Cart(customer.getCustomerId(),cartBookName,bookSellPrice,cartBookCount,cartBookDiscount,cartBookAllprices);
        System.out.println("要添加的购物车信息：" + cart);
        List<Cart> ucart = cartService.getCartByCustomerId(customer.getCustomerId());
        System.out.println(ucart);
        if (ucart == null){
            cartService.addCartNull(cart);
        } else {
            cartService.updateCountAdd(cartBookCount,cartBookName);
        }
        return "user/userIndex";
    }


}
