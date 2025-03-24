package com.example.demo.model;

public class UserToken {
    private String userName;   //用户名
    private String role;   //权限集合

    public UserToken() {

    }
    public UserToken(String userName,String role) {
        this.userName = userName;
        this.role = role;
    }
    public String getUserName() {
        return userName;
    }

    public String setUserName(String userName) {
        return this.userName = userName;
    }

    public String getPermission() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}