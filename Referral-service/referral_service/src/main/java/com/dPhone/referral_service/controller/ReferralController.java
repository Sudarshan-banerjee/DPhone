package com.dPhone.referral_service.controller;

import com.dPhone.referral_service.bean.ReferralBean;

import com.dPhone.referral_service.service.ReferralDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("referral")
public class ReferralController {
    @Autowired
    private ReferralDaoImpl referralDaoImpl;

    @PostMapping(value="add")
    public ResponseEntity<ReferralBean> addReferral(@RequestBody ReferralBean referralBean) {
        ReferralBean info = referralDaoImpl.addReferral(referralBean);
        return new ResponseEntity<>(info, HttpStatus.OK);
    }

    @GetMapping(value="show-referrals")
    public ResponseEntity<List<ReferralBean>> showReferrals()
    {
        List<ReferralBean> referrals=referralDaoImpl.showAll();
        return new ResponseEntity<>(referrals,HttpStatus.OK);
    }

    @GetMapping(value="show-referrals/{userId}")
    public ResponseEntity<List<ReferralBean>> showReferralsById(@PathVariable(value="userId") int userId)
    {
        List<ReferralBean> referralsById=referralDaoImpl.findById(userId);
        return new ResponseEntity<>(referralsById,HttpStatus.OK);
    }

    @DeleteMapping(value="delete/{referralId}")
    public ResponseEntity<String> deleteById(@PathVariable(value="referralId") int referralId)
    {
        if(referralDaoImpl.deleteReferral(referralId))
            return new ResponseEntity<>("Deleted Successfully.",HttpStatus.OK);
        else
            return new ResponseEntity<>("Referral id does not exist.",HttpStatus.OK);
    }

    //Returns userId= 0 if referral does not exist
    @PostMapping(value="referral-use")
    public ResponseEntity<Integer> useReferral(@RequestBody ReferralBean referralBean)
    {
        int userId=0;
        String userName=referralBean.getUsername();
        List<ReferralBean> referrals=referralDaoImpl.showAll();
        for(ReferralBean referral:referrals)
        {
            if(referral.getUsername().equals(userName) && referral.getStatus())
            {
                userId=referral.getUserId();
                referralDaoImpl.updateStatus(referral);
                break;
            }
        }
        return new ResponseEntity<>(userId,HttpStatus.OK);
    }


}
