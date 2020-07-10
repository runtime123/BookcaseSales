package com.controller.loginandregist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogAndRegController {
    //进入登录界面
    @RequestMapping("/login")
    public String login(){
        return "login_and_regist/login";
    }

    //进入注册界面
    @RequestMapping("/regist")
    public String regist(){
        return "login_and_regist/regist";
    }

    //进入OK界面
    @RequestMapping("/ok")
    public String ok(){
        return "login_and_regist/ok";
    }

    //进入图书管理界面
    @RequestMapping("/bookManager")
    public String bookList(){
        return "book/bookManager";
    }

    //进入用户管理界面
    @RequestMapping("/userManager")
    public String userList(){
        return "manager/userManager";
    }

    //进入管理员首页
    @RequestMapping("/managerIndex")
    public String managerIndex(){
        return "manager/managerIndex";
    }

    //重定向，进入用户首页
    @RequestMapping("/userIndex")
    public String userIndex(){
        return "redirect:shouye";
    }
}
