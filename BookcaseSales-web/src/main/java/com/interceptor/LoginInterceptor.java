package com.interceptor;

import com.entity.Customer;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("pre-------------------------------------------");
        //给一个boolean值，根据查询结果判断是否拦截
        boolean result = true;
        //查询用户账号信息
        Customer customer = (Customer) request.getSession().getAttribute("customer1");
        //判断用户是否登录，该用户账号没登录的话拦截下该用户的操作
        if (customer == null){
            request.getRequestDispatcher("/WEB-INF/views/login_and_regist/login.jsp").forward(request,response);
            result = false;
        }
        return result;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("已完成拦截验证操作");
    }

}
