package com.dphone.user.bean;

public class UserBean {
	
	private int userId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private int referralPoints;
	
	public UserBean(int userId, String firstName, String lastName, String userName, String password,
			int referralPoints) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.referralPoints = referralPoints;
	}
	public int getReferralPoints() {
		return referralPoints;
	}
	public void setReferralPoints(int referralPoints) {
		this.referralPoints = referralPoints;
	}
	@Override
	public String toString() {
		return "UserBean [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", password=" + password + ", referralPoints=" + referralPoints + "]";
	}
	public UserBean() {
		super();
	}
	public UserBean(int userId, String firstName, String lastName, String userName, String password) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
