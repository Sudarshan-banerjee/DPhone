package com.dphone.customer.controller;

import com.dphone.customer.bean.CustomerBean;
import com.dphone.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/customer/")
@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/addCustomer")
    public ResponseEntity<Boolean> addCustomer (@RequestBody CustomerBean customerBean){
        System.out.println("Controller "+ customerBean);
        boolean status = customerService.addCustomer(customerBean);
        return new ResponseEntity<Boolean>(status, HttpStatus.OK);
    }

    @GetMapping(value = "showCustomer/{customer_id}")
    public ResponseEntity<CustomerBean> showCustomer (@PathVariable("customer_id") long customer_id){
        CustomerBean customerBean = customerService.showCustomer(customer_id);
        return new ResponseEntity<CustomerBean>(customerBean,HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteCustomer/{customer_id}")
    public ResponseEntity<Boolean> deleteCustomer (@PathVariable("customer_id") long customer_id){
        boolean status = customerService.deleteCustomer(customer_id);
        return new ResponseEntity<Boolean>(status,HttpStatus.OK);
    }

    @PutMapping(value = "/updateCustomer/{customer_id}")
    public ResponseEntity<Boolean> updateCustomer (@RequestBody CustomerBean customerBean){
        boolean status = customerService.updateCustomer(customerBean);
        return new ResponseEntity<Boolean>(status,HttpStatus.OK);
    }


}
