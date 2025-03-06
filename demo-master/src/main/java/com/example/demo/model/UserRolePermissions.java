package com.example.demo.model;

import java.util.Date;
import java.io.Serializable;

/**
 * (UserRolePermissions)实体类
 *
 * @author makejava
 * @since 2024-12-13 16:26:59
 */
public class UserRolePermissions implements Serializable {
    private static final long serialVersionUID = -76876440481847883L;

    private Integer userId;

    private String userName;

    private Integer roleId;

    // 在线状态
    private Integer userStatus;

    private Date applicationTime;

    private String userIntro;

    private Boolean tableStatus;

    private String userPwd;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public String getUserIntro() {
        return userIntro;
    }

    public void setUserIntro(String userIntro) {
        this.userIntro = userIntro;
    }

    public Boolean getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(Boolean tableStatus) {
        this.tableStatus = tableStatus;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

}

