package com.ysys520.mall.entity;

/**
 * Created by hejingzhou on 2017/7/16.
 */
public class User {
    private long id;
    private String userName;
    private String password;
    private String sex;
    private String phone;

    public User(long id, String userName, String password, String sex, String phone) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.phone = phone;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
