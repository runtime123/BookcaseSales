package com.com.manager;

import com.entity.Customer;
import com.github.pagehelper.Page;
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
public class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void query() {
        List<Customer> customers = customerService.getAllUserByPage(0,1,4);
        PageInfo customerList = new PageInfo(customers);
        customerList.toString();
    }

    @Test
    public void update() {
        Customer customer = new Customer(1,"admin","888888","18370014966","北京完美世界界","206088745@qq.com",0);
        customerService.update(customer);
    }

    @Test
    public void delete() {
        customerService.delete(7);
    }
}
