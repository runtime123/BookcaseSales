package com.user;

import com.entity.Cart;
import com.service.CartService;
import config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestCartServiceImpl {
    @Autowired
    private CartService cartService;

    @Test
    public void getCartByCustomerId() {
        cartService.getCartByCustomerId(4);
    }

    @Test
    public void addCartNull() {
        Cart cart = new Cart(4,"34r4r", BigDecimal.valueOf(10),1,9,BigDecimal.valueOf(18));
        cartService.addCartNull(cart);
    }

    @Test
    public void updateCountAdd() {
        cartService.updateCountAdd(1,"《吞噬星空》");
    }

    @Test
    public void updateCountSub() {
        cartService.updateCountSub(1,"《吞噬星空》");
    }

    @Test
    public void querySettlementCart() {
        cartService.querySettlementCart(6,"《列宁主义》");
    }

    @Test
    public void deleteOne() {
        cartService.deleteOne(5,"《吞噬星空》");
    }

    @Test
    public void deleteByCartCustomerId() {
        cartService.deleteByCartCustomerId(5);
    }

    @Test
    public void getCartByCartId(){
        cartService.getCartByCartId(4);
    }

}
