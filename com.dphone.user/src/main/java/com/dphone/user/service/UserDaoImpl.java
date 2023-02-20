package com.dphone.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dphone.user.bean.UserBean;
import com.dphone.user.dao.UserDao;
import com.dphone.user.entity.UserEntity;

@Service
public class UserDaoImpl {
	
	@Autowired
	private UserDao userDao;
	
	public UserBean addUser(UserBean userBean) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userBean, userEntity);
		userDao.save(userEntity);
		BeanUtils.copyProperties(userEntity, userBean);
		return userBean;
	}
	
	public boolean deleteUser(int userId) {
		if(userDao.existsById(userId)) {
			userDao.deleteById(userId);
			return true;
		}else {
			return false;
		}
	}
	
	public UserBean updateUser(UserBean userBean) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userBean, userEntity);
		userDao.save(userEntity);
		BeanUtils.copyProperties(userEntity, userBean);
		return userBean;
	}
	
	public List<UserBean> getUserById(int userId) {
		List<UserEntity> entities = userDao.findAll();
		List<UserBean> beans = new ArrayList<>();
		for(UserEntity entity: entities) {
			if(entity.getUserId()==userId) {
				UserBean bean = new UserBean();
				BeanUtils.copyProperties(entity, bean);
				beans.add(bean);
			}
		}
		return beans;
	}
	public boolean validateUser(String userName, String password) {
		List<UserEntity> userEntity = userDao.findAll();
		System.out.println(userEntity);
		System.out.println(userName);
		System.out.println(password);
		for(UserEntity entity: userEntity) {
			if(entity.getUserName().equals(userName) && entity.getPassword().equals(password)) {
				System.out.println("Hello");
				return true;
			}
		}
		return false;
	}
	public void addPoints(int userId){
		List<UserEntity> entities = userDao.findAll();
		
		for(UserEntity entity: entities) {
			if(entity.getUserId()==userId) {
				UserBean bean = new UserBean();
//				userDao.delete(entity);
				entity.setReferralPoints(entity.getReferralPoints()+1000);
				userDao.save(entity);
				BeanUtils.copyProperties(entity, bean);
				System.out.println(entity);
			}
		}
	}
}

