package com.example.demo.model;

import java.util.Date;
import java.io.Serializable;

/**
 * (ApprovalRecords)实体类
 *
 * @author makejava
 * @since 2024-12-12 16:08:04
 */
public class ApprovalRecords implements Serializable {
    private static final long serialVersionUID = -72281104509060391L;

    private Integer approvalId;

    private Integer achievementId;

    private String approvalType;

    private Integer approvalStatus;

    private Integer userId;

    private String approvalTime;

    private Boolean tableStatus;


    public Integer getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(Integer approvalId) {
        this.approvalId = approvalId;
    }

    public Integer getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Integer achievementId) {
        this.achievementId = achievementId;
    }

    public String getApprovalType() {
        return approvalType;
    }

    public void setApprovalType(String approvalType) {
        this.approvalType = approvalType;
    }

    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(String approvalTime) {
        this.approvalTime = approvalTime;
    }

    public Boolean getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(Boolean tableStatus) {
        this.tableStatus = tableStatus;
    }

}

