package com.dPhone.referral_service.bean;

public class ReferralBean {
    private int referralId;
    private String firstName;
    private String lastName;
    private String mobile;
    private String username;
    private String date;
    private boolean status;
    private int userId;

    public ReferralBean() {
        super();
    }

    public ReferralBean(int referralId, String firstName, String lastName, String mobile, String username,  boolean status, int userId,String date) {
        super();
        this.referralId = referralId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.username = username;
        this.date = date;
        this.status = status;
        this.userId = userId;
    }


    @Override
    public String toString() {
        return "ReferralBean{" +
                "referralId=" + referralId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", username='" + username + '\'' +
                ", date=" + date +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }

    public int getReferralId() {
        return referralId;
    }

    public void setReferralId(int referralId) {
        this.referralId = referralId;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
