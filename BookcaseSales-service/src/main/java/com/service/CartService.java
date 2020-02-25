package com.service;

import com.entity.Cart;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {

    //查询该用户的购物车中的所有信息
    List<Cart> getCartByCustomerId(int CartCustomerId);
    //如果购物车为空，添加该商品信息
    int addCartNull(Cart cart);
    //商品数量+1
    int updateCountAdd(int count,String CartBookName);
    //商品数量-1
    int updateCountSub(int count,String CartBookName);
    //删除购物车中的某本图书
    int deleteOne(int CartCustomerId,String CartBookName);
    //清空购物车
    int deleteByCartCustomerId(int CartCustomerId);
    //根据用户编号查询用户信息
    Cart querySettlementCart(int cartCustomerId,String cartBookName);

    Cart getCartByCartId(int CartId);

}
