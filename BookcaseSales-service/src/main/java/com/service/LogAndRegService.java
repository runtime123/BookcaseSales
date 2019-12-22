package com.service;


import com.entity.Customer;

public interface LogAndRegService {

    Customer userLogin(Customer customer);

    int userRegist(Customer customer);

}
