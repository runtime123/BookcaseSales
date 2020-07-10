package com.manager;

import com.entity.Customer;
import com.github.pagehelper.PageInfo;
import com.service.CustomerService;
import config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestCustomerServiceImpl {

    @Autowired
    private CustomerService customerService;

    /*
        测试内容：根据用户类型查询用户信息
     */
    @Test
    public void query() {
        List<Customer> customers = customerService.getAllUserByPage(0,1,4);
        PageInfo customerList = new PageInfo(customers);
        customerList.toString();
    }

    /*
        测试内容：修改用户信息
     */
    @Test
    public void update() {
        Customer customer = new Customer(1,"admin","111111","18370014966","北京市完美世界区","206088745@qq.com",2);
        customerService.update(customer);
    }

    /*
        测试内容：删除用户信息
     */
    @Test
    public void delete() {
        customerService.delete(7);
    }
}
