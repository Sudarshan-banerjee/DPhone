package com.dphone.user.feign.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dphone.user.bean.ReferralBean;
import com.dphone.user.feign.service.UserReferralConnect;

@RestController
@RequestMapping("ref")
@CrossOrigin(origins="*")
public class UserReferralConnectController {
	
	@Autowired
	private UserReferralConnect userReferralConnect;
	
	@RequestMapping(value="get-id", method=RequestMethod.GET)
	public ResponseEntity<?> getUserIdFromRef(int userId){
		int id = userReferralConnect.getUserIdFromRef(userId);
		return new ResponseEntity<>(userId, HttpStatus.OK);
//		int userId=0;
//        String userName=referralBean.getUsername();
//        List<ReferralBean> referrals=referralDaoImpl.showAll();
//        System.out.println(referrals);
//        System.out.println(userName);
//        for(ReferralBean referral:referrals)
//        {
//            if(referral.getUsername().equals(userName) && referral.getStatus())
//            {
//                userId=referral.getUserId();
//                referralDaoImpl.updateStatus(referral);
//                break;
//            }
//        }
//        return new ResponseEntity<Integer>(userId, HttpStatus.OK);
	}
	
	  @PostMapping(value = "use-referral")
	    public ResponseEntity<Integer> useReferral(@RequestBody ReferralBean referralBean)
	    {
		  
		  ResponseEntity<Integer> response = userReferralConnect.useReferral(referralBean);
		  
		  return response;
	    }
}
