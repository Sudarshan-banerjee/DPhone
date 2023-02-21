package com.dPhone.referral_service.service;


import com.dPhone.referral_service.bean.ReferralBean;
import com.dPhone.referral_service.dao.ReferralDao;
import com.dPhone.referral_service.entity.ReferralEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReferralDaoImpl {

    @Autowired
    private ReferralDao referralDao;

    public List<ReferralBean> showAll()
    {
        List<ReferralEntity> entities = referralDao.findAll();
        List<ReferralBean> beans = new ArrayList<>();
        for (ReferralEntity entity: entities) {
            ReferralBean bean = new ReferralBean();
            BeanUtils.copyProperties(entity,bean);
            beans.add(bean);
        }
        return beans;
    }

    public List<ReferralBean> findById(int userId)
    {
        List<ReferralEntity> entities = referralDao.findAll();
        List<ReferralBean> beans = new ArrayList<>();
        for (ReferralEntity entity: entities) {
            if(entity.getUserId()==userId) {
                ReferralBean bean = new ReferralBean();
                BeanUtils.copyProperties(entity, bean);
                beans.add(bean);
            }
        }

        return beans;
    }

    public ReferralBean addReferral(ReferralBean referralBean)
    {
        List<ReferralEntity> list=referralDao.findAll();
//
        ReferralEntity referralEntity = new ReferralEntity();
        BeanUtils.copyProperties(referralBean, referralEntity);
        for(ReferralEntity entity:list)
        {
            if(entity.getUsername().equals(referralBean.getUsername()))
            {
                BeanUtils.copyProperties(entity,referralBean);
                updateStatus(referralBean);
                System.out.println("Username matched");

                return referralBean;
            }
        }
        referralDao.save(referralEntity);
        BeanUtils.copyProperties(referralEntity, referralBean);
        return referralBean;
    }

    public boolean deleteReferral(int referralId)
    {
        List<ReferralEntity> entities = referralDao.findAll();
        for (ReferralEntity entity: entities) {
            if(entity.getReferralId()==referralId) {
                referralDao.delete(entity);
                return true;
            }
        }
        return false;
    }
    public void updateStatus(ReferralBean referralBean)
    {
        referralBean.setStatus(!referralBean.getStatus());
        ReferralEntity referralEntity=new ReferralEntity();
        BeanUtils.copyProperties(referralBean,referralEntity);

        referralDao.save(referralEntity);

    }


}
