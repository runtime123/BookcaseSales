package com.controller.loginandregist;


import com.entity.Customer;
import com.service.LogAndRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistController {

    @Autowired
    private LogAndRegService logAndRegService;

    @RequestMapping("/zhuce")
    @ResponseBody
    public String userRegist(@RequestBody Customer customer){
        String url = null;
        System.out.println(customer);
        //通过获取的用户信息new一个Customer
        Customer customer1 = new Customer(customer.getCustomerName(),customer.getCustomerPwd(),customer.getCustomerPhone(),customer.getCustomerAddress(),customer.getCustomerEmail(),0);
        //进行后台设置customerType的登录
        int result = logAndRegService.userRegist(customer1);
        if (result > 0) {
            url = "ok";
        } else {
            url = "regist";
        }
        return url;
    }




}
