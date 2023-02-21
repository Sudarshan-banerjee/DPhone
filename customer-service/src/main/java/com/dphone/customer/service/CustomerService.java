package com.dphone.customer.service;

import com.dphone.customer.bean.CustomerBean;

public interface CustomerService {
    boolean addCustomer (CustomerBean customerBean);
    CustomerBean showCustomer (long customerId);
    boolean deleteCustomer (long customerId);
    boolean updateCustomer (CustomerBean customerBean);
}
