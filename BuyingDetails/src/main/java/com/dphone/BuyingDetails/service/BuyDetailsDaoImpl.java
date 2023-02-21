package com.dphone.BuyingDetails.service;

import com.dphone.BuyingDetails.bean.BuyDetailsBean;
import com.dphone.BuyingDetails.dao.BuyDetailsDao;
import com.dphone.BuyingDetails.entity.BuyDetails;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuyDetailsDaoImpl {


    @Autowired
    private BuyDetailsDao buyDetailsDao;

    public List<BuyDetails> findAll() {
        return buyDetailsDao.findAll();
    }

    public BuyDetailsBean addProduct(BuyDetailsBean buyDetailsBean) {
        BuyDetails buyDetails = new BuyDetails();
        BeanUtils.copyProperties(buyDetailsBean, buyDetails);
        buyDetailsDao.save(buyDetails);
        return buyDetailsBean;
    }

    public List<BuyDetailsBean> findById(long userId) {
        List<BuyDetails> entities = buyDetailsDao.findAll();
        List<BuyDetailsBean> beans = new ArrayList<>();
        for (BuyDetails entity : entities) {
            if (entity.getUserId() == userId) {
                BuyDetailsBean bean = new BuyDetailsBean();
                BeanUtils.copyProperties(entity, bean);
                beans.add(bean);
            }
        }
    return beans;
    }

    public List<BuyDetailsBean> showAll()
    {
        List<BuyDetails> entities = buyDetailsDao.findAll();
        List<BuyDetailsBean> beans = new ArrayList<>();
        for (BuyDetails entity: entities) {
            BuyDetailsBean bean = new BuyDetailsBean();
            BeanUtils.copyProperties(entity,bean);
            beans.add(bean);
        }
        return beans;
    }
}