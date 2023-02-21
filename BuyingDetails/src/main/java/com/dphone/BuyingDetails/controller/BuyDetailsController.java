package com.dphone.BuyingDetails.controller;

import com.dphone.BuyingDetails.bean.BuyDetailsBean;
import com.dphone.BuyingDetails.entity.BuyDetails;
import com.dphone.BuyingDetails.service.BuyDetailsDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("buying-details")
public class BuyDetailsController {
    @Autowired
    private BuyDetailsDaoImpl BuyDetailsDaoImpl;

    @GetMapping("/test")
    public String testApi(){
        return "working";
    }
    @RequestMapping(value="/addProduct", method= RequestMethod.POST)
    public ResponseEntity<BuyDetailsBean> addProduct(@RequestBody BuyDetailsBean buyDetailsBean)
    {
        BuyDetailsBean info = BuyDetailsDaoImpl.addProduct(buyDetailsBean);
        return new ResponseEntity<BuyDetailsBean>(info, HttpStatus.OK);
    }
    @RequestMapping(value ="/showProduct/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<BuyDetailsBean>> showProductbyId(@PathVariable(value="userId")long userId)
    {
        List<BuyDetailsBean> list= BuyDetailsDaoImpl.findById(userId);
        return new ResponseEntity<List<BuyDetailsBean>>(list,HttpStatus.OK);
    }
    @RequestMapping(value="showProduct",method = RequestMethod.GET)
    public ResponseEntity<List<BuyDetailsBean>> showReferrals()
    {
        List<BuyDetailsBean> products = BuyDetailsDaoImpl.showAll();
        return new ResponseEntity<List<BuyDetailsBean>>(products,HttpStatus.OK);
    }




}

