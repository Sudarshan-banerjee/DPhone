package com.dphone.user.feign.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dphone.user.bean.ReferralBean;
//import com.dPhone.referral_service.bean.ReferralBean;
import com.dphone.user.bean.UserBean;

@FeignClient(url="http://localhost:8083/referral", name="REFERRAL-SERVICE")
public interface UserReferralConnect {
	
	@RequestMapping(value="referral-use/{userId}", method=RequestMethod.GET)
//	@GetMapping("/referral-use")
	public int getUserIdFromRef(@PathVariable(value="userId") int userId);
	
//	@RequestMapping(value="referral-use", method=RequestMethod.GET)
//	public int getUserIdFromRef();
//	
	
    @PostMapping(value = "use-referral")
    public ResponseEntity<Integer> useReferral(@RequestBody ReferralBean referralBean);
    
}
