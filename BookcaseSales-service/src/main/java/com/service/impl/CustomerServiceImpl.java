package com.service.impl;

import com.dao.CustomerDao;
import com.entity.Customer;
import com.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired//自动注入customerDao
    private CustomerDao customerDao;

    @Override
    public List<Customer> getAllUserByPage(int customerType, int pageNum, int pageSize) {
        return customerDao.getAllUserByPage(customerType,pageNum,pageSize);
    }

    @Override
    public void delete(int customerId) {
        customerDao.delete(customerId);
    }

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public Customer queryone(int customerId) {
        return customerDao.queryone(customerId);
    }
}
