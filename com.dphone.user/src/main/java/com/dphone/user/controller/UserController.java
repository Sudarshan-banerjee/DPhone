package com.dphone.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dphone.user.bean.UserBean;
import com.dphone.user.feign.service.UserReferralConnect;
import com.dphone.user.service.UserDaoImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("user")
public class UserController {
	
	List<Integer> list = new ArrayList<Integer>();
	
	@Autowired
	private UserDaoImpl userDaoImpl;
	
	@Autowired
	private UserReferralConnect userReferralConnect;
	@CrossOrigin(origins = {"http://127.0.0.1:5500/","http://127.0.0.1:8085/"})
	

	@RequestMapping(value="add-user", method=RequestMethod.POST)
	public ResponseEntity<UserBean> addUser(@RequestBody UserBean userBean){
		
		UserBean info = userDaoImpl.addUser(userBean);
		System.out.println(userBean);
		return new ResponseEntity<UserBean>(info,HttpStatus.OK);
	}
	@RequestMapping(value="delete-user/{userId}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteUser(@PathVariable(value="userId") int userId){
		boolean status = userDaoImpl.deleteUser(userId);
		return new ResponseEntity<Boolean>(status,HttpStatus.OK);
	}
	@RequestMapping(value="update-user", method=RequestMethod.PUT)
	public ResponseEntity<UserBean> updateUser(@RequestBody UserBean userBean){
		UserBean info = userDaoImpl.updateUser(userBean);
		return new ResponseEntity<UserBean>(info,HttpStatus.OK);
	}
	@RequestMapping(value="get-user/{userId}", method=RequestMethod.GET)
	public ResponseEntity<List<UserBean>> showUserById(@PathVariable(value="userId") int userId){
		List<UserBean> userById = userDaoImpl.getUserById(userId);
		return new ResponseEntity<List<UserBean>>(userById,HttpStatus.OK);
	}
	@RequestMapping(value="add-points/{userId}", method=RequestMethod.POST)
	public void addPoints(@PathVariable(value="userId") int userId){
		userDaoImpl.addPoints(userId);
		System.out.println("Its working");
	}
	@RequestMapping(value="login/uName={username}&&pass={password}", method=RequestMethod.GET)
	public ResponseEntity<Boolean> validateUser(@PathVariable(value="username") String userName, @PathVariable(value="password") String password){
		//boolean status=userDaoImpl.validateUser(userName.substring(0,userName.length()), password.substring(1,password.length()-1));
		boolean status=userDaoImpl.validateUser(userName, password);
		
		return new ResponseEntity<Boolean>(status,HttpStatus.OK);
	}
//	@RequestMapping(value="check-feign")
//	public void checkFeign() {
//		userReferralConnect.check();
//	}
}