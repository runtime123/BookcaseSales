package com.controller.loginandregist;


import com.entity.Customer;
import com.service.LogAndRegService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LogAndRegService logAndRegService;

    //用户登录
    @RequestMapping("/denglu")
    @ResponseBody
    public String userLogin(@RequestBody Customer customer, Model model, HttpServletRequest request){
        //初始返回值为login
        String url = "login";
        //根据登录信息查询用户是否存在
        Customer customer1 = logAndRegService.userLogin(customer);
        //request记录会话信息
        HttpSession session = request.getSession();
        session.setAttribute("customer1",customer1);
        //判断该用户是否存在
        if (customer1 != null) {
            //判断用户类型
            if (customer1.getCustomerType().equals(1)) {
                url = "manager";//管理员首页地址
            } else if (customer1.getCustomerType().equals(0)){
                url = "customer";//用户首页地址
            } else {
                //错误信息
                request.setAttribute("errMsg","登陆失败，该用户不存在");
            }
        }
        //最终返回地址
        return url;
    }

    //用户注销
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request,Model model){
        //在会话作用域中移除该用户信息
        request.getSession().removeAttribute("customer1");
        //重定向到用户主界面
        return "redirect:userIndex";
    }



}
