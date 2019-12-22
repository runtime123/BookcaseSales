package com.service.impl;

import com.dao.LogAndRegDao;

import com.entity.Customer;
import com.service.LogAndRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogAndRegServiceImpl implements LogAndRegService {

    @Autowired
    private LogAndRegDao logAndRegDao;

    @Override
    public Customer userLogin(Customer customer) {
        return logAndRegDao.userLogin(customer);
    }

    @Override
    public int userRegist(Customer customer) {
        return logAndRegDao.userRegist(customer);
    }


}
