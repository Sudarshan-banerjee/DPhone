package com.dPhone.referral_service.dao;


import com.dPhone.referral_service.entity.ReferralEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferralDao extends JpaRepository<ReferralEntity, Integer> {

}
