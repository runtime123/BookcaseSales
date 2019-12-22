package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Customer {
    private Integer CustomerId;
    private String CustomerName;
    private String CustomerPwd;
    private String CustomerPhone;
    private String CustomerAddress;
    private String CustomerEmail;
    private Integer CustomerType;

    //虽然@Data会自动生成get，set方法，但要调用某一个字段的get方法还是要在实体类里面写这个方法，


    public Integer getCustomerId() {
        return CustomerId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public String getCustomerPwd() {
        return CustomerPwd;
    }

    public String getCustomerPhone() {
        return CustomerPhone;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public Integer getCustomerType() {
        return CustomerType;
    }

    public Customer() {
    }

    public Customer(String customerName, String customerPwd) {
        CustomerName = customerName;
        CustomerPwd = customerPwd;
    }

    public Customer(String customerName, String customerPwd, String customerPhone, String customerAddress, String customerEmail, Integer customerType) {
        CustomerName = customerName;
        CustomerPwd = customerPwd;
        CustomerPhone = customerPhone;
        CustomerAddress = customerAddress;
        CustomerEmail = customerEmail;
        CustomerType = customerType;
    }

    public Customer(String customerName, String customerPwd, String customerPhone, String customerAddress, String customerEmail) {
        CustomerName = customerName;
        CustomerPwd = customerPwd;
        CustomerPhone = customerPhone;
        CustomerAddress = customerAddress;
        CustomerEmail = customerEmail;
    }

    public Customer(Integer customerId, String customerName, String customerPwd, String customerPhone, String customerAddress, String customerEmail, Integer customerType) {
        CustomerId = customerId;
        CustomerName = customerName;
        CustomerPwd = customerPwd;
        CustomerPhone = customerPhone;
        CustomerAddress = customerAddress;
        CustomerEmail = customerEmail;
        CustomerType = customerType;
    }
}