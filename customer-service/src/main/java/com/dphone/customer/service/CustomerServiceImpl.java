package com.dphone.customer.service;

import com.dphone.customer.bean.CustomerBean;
import com.dphone.customer.dao.CustomerDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerDaoImpl customerDaoImpl;

    @Override
    public boolean addCustomer (CustomerBean customerBean){
        System.out.println("Service impl "+ customerBean);
        return customerDaoImpl.addCustomer(customerBean);
    }

    @Override
    public CustomerBean showCustomer(long customerId) {
        return customerDaoImpl.showCustomer(customerId);
    }

    @Override
    public boolean deleteCustomer (long customerId) {
        return customerDaoImpl.deleteCustomer(customerId);
    }
    @Override
    public boolean updateCustomer (CustomerBean customerBean) {
        return customerDaoImpl.updateCustomer(customerBean);
    }

}
