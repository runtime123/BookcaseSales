package com.controller.manager;

import com.entity.Customer;
import com.github.pagehelper.PageInfo;
import com.service.CustomerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/m/customer")
public class CustomerManager {
    @Autowired//导入customerService Bean
    private CustomerService customerService;

    //根据用户类型分页查询所有用户信息
    @RequestMapping("/getAllUserByPage")
    public String query(@RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                        @RequestParam(value = "pageSize",defaultValue = "2",required = false) int pageSize,
                                        Model model){
        //所有类型为0的使用者即用户
        List<Customer> customers = customerService.getAllUserByPage(0,pageNum,pageSize);
        //分页处理
        PageInfo customerList = new PageInfo(customers);

        model.addAttribute("customerList",customerList);
        return "manager/user/customerManager";
    }


    /**
     * 进入修改界面修改用户信息
     * @param customerId
     * @param model
     * @return
     */
    @RequestMapping("/toUpdate")
    public String toUpdate(@RequestParam(value = "customerId",required = false) int customerId,Model model){
        Customer uCustomer = customerService.queryone(customerId);
        model.addAttribute("uCustomer",uCustomer);
        return "manager/user/customerUpdate";
    }



    /**
     * 进行修改用户信息
     * @param customer
     * @return
     */
    @RequestMapping("/doUpdate")
    public String doUpdate(@RequestBody Customer customer){
        customerService.update(customer);
        return "manager/user/customerManager";
    }
    //删除用户信息
    @RequestMapping("/delete")
    public String delete(@RequestParam(value = "customerId",required = false) int customerId){
        customerService.delete(customerId);
        return "manager/user/customerManager";
    }


}
