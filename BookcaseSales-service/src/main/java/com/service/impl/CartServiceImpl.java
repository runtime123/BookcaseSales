package com.service.impl;

import com.dao.CartDao;
import com.entity.Cart;
import com.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired//(required = false)
    private CartDao cartDao;

    //查询该用户的购物车中的所有信息
    @Override
    public List<Cart> getCartByCustomerId(int CartCustomerId) {
        return cartDao.getCartByCustomerId(CartCustomerId);
    }

    //如果购物车为空，添加该商品信息
    @Override
    public int addCartNull(Cart cart) {
        return cartDao.addCartNull(cart);
    }

    //商品数量+1
    @Override
    public int updateCountAdd(int count,String CartBookName) {
        return cartDao.updateCountAdd(count,CartBookName);
    }

    //商品数量-1
    @Override
    public int updateCountSub(int count,String CartBookName) {
        return cartDao.updateCountSub(count,CartBookName);
    }

    //删除购物车中的1本图书
    @Override
    public int deleteOne(int CartCustomerId, String CartBookName) {
        return cartDao.deleteOne(CartCustomerId,CartBookName);
    }


    //清空购物车
    @Override
    public int deleteByCartCustomerId(int CartCustomerId) {
        return cartDao.deleteByCartCustomerId(CartCustomerId);
    }

    @Override
    public Cart querySettlementCart(int cartCustomerId, String cartBookName) {
        return cartDao.querySettlementCart(cartCustomerId,cartBookName);
    }

    @Override
    public Cart getCartByCartId(int CartId) {
        return cartDao.getCartByCartId(CartId);
    }

    @Override
    public List<Cart> getCartByCustomerIdAndCartBookName(int cartCustomerId, String cartBookName) {
        return cartDao.getCartByCustomerIdAndCartBookName(cartCustomerId, cartBookName);
    }


}
