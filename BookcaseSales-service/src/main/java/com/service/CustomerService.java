package com.service;

import com.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllUserByPage(int customerType, @Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    void delete(int customerId);

    void update(Customer customer);

    Customer queryone(int customerId);
}
