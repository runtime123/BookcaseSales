package com.dao;

import com.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerDao {

    List<Customer> getAllUserByPage(@Param("customerType") int customerType, @Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    void delete(int customerId);

    void update(Customer customer);

    Customer queryone(int customerId);
}
