package com.dphone.customer.dao;

import com.dphone.customer.bean.CustomerBean;
import com.dphone.customer.entity.CustomerEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerDaoImpl {
    @Autowired
    public CustomerDao customerDao;
    public boolean addCustomer (CustomerBean customerBean){
        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(customerBean, customerEntity);
        try {
            customerDao.save(customerEntity);
        } catch (IllegalArgumentException e){
            return false;
        }
        return true;
    }

    public CustomerBean showCustomer(long customerId){
        try{
            CustomerEntity customerEntity = customerDao.getReferenceById(customerId);
            CustomerBean customerBean = new CustomerBean();
            BeanUtils.copyProperties(customerEntity, customerBean);
            return customerBean;
        } catch (IllegalArgumentException e) {
            return  null;
        }

    }

    public boolean deleteCustomer(long customerId){
        try{
            customerDao.deleteById(customerId);

        } catch (IllegalArgumentException e){
            return false;
        }
        return true;
    }

    public boolean updateCustomer (CustomerBean customerBean){
        try {
            CustomerEntity customerEntity = new CustomerEntity();
            BeanUtils.copyProperties(customerBean, customerEntity);
            customerDao.save(customerEntity);
        } catch (IllegalArgumentException e){
            return false;
        }
        return true;
    }
}
