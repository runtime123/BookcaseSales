package com.dao;


import com.entity.Customer;
import org.apache.ibatis.annotations.Param;

public interface LogAndRegDao {

    Customer userLogin(Customer customer);

    int userRegist(Customer customer);



}
