package com.com.other;

import com.entity.Customer;
import com.service.LogAndRegService;
import config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class LogAndRegTest {
    @Autowired
    private LogAndRegService logAndRegService;
    @Test
    public void login() {
        Customer customer = new Customer("辰东","666666");
        logAndRegService.userLogin(customer);
    }

    @Test
    public void regist() {
        Customer customer = new Customer("曹雨生2","666666","18370014966","北京完美世界界","206088745@qq.com",0);
        logAndRegService.userRegist(customer);
    }
}
