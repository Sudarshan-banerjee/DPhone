package com.dphone.BuyingDetails.dao;

import com.dphone.BuyingDetails.entity.BuyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyDetailsDao extends JpaRepository<BuyDetails,Long> {

}
