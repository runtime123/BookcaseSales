package com.controller.manager;

import com.entity.Customer;
import com.github.pagehelper.PageInfo;
import com.service.CustomerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/customerManager")
public class CustomerManager {
    @Autowired//导入customerService Bean
    private CustomerService customerService;

    //分页查询所有用户信息
    @RequestMapping("/query")
    private String query(int customerType,@RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                        @RequestParam(value = "pageSize",defaultValue = "4",required = false) int pageSize,
                                        HttpServletRequest request){
        //所有类型为0的使用者即用户
        List<Customer> customers = customerService.getAllUserByPage(0,pageNum,pageSize);
        //分页处理
        PageInfo customerList = new PageInfo(customers);

        request.setAttribute("customerList",customerList);

        return "manager/user/customerManager";
    }


    //修改用户信息
    @RequestMapping("/toUpdate")
    public String toUpdate(int customerId,Model model){
        Customer customer = customerService.queryone(customerId);
        model.addAttribute("uCustomer",customer);
        return "manager/user/customerUpdate";
    }

    @RequestMapping("/doUpdate")
    public String doUpdate(Customer customer){
        customerService.update(customer);
        return "manager/user/customerManager";
    }
    //删除用户信息
    @RequestMapping("/delete")
    public String delete(int customerId){
        customerService.delete(customerId);
        return "manager/user/customerManager";
    }

    @RequestMapping("/manager")
    public String manager(){
        return "manager/user/customerManager";
    }
}
