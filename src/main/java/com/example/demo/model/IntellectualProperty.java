package com.example.demo.model;

import java.util.Date;
import java.io.Serializable;

/**
 * (IntellectualProperty)实体类
 *
 * @author makejava
 * @since 2025-01-15 14:45:10
 */
public class IntellectualProperty implements Serializable {
    private static final long serialVersionUID = -14505818150917238L;

    private Integer intellectualPropertyId;

    private String intellectualPropertyType;

    private String applicationDate;

    private String expirationDate;

    private Boolean renewalStatus;

    private Boolean tableStatus;

    private Integer achievementId;

    private String intellectualNo;

    private String intellectualName;

    private String organizationName;

    private String projectNo;

    private String userName;

    private Integer auditFlag;


    public Integer getIntellectualPropertyId() {
        return intellectualPropertyId;
    }

    public void setIntellectualPropertyId(Integer intellectualPropertyId) {
        this.intellectualPropertyId = intellectualPropertyId;
    }

    public String getIntellectualPropertyType() {
        return intellectualPropertyType;
    }

    public void setIntellectualPropertyType(String intellectualPropertyType) {
        this.intellectualPropertyType = intellectualPropertyType;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Boolean getRenewalStatus() {
        return renewalStatus;
    }

    public void setRenewalStatus(Boolean renewalStatus) {
        this.renewalStatus = renewalStatus;
    }

    public Boolean getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(Boolean tableStatus) {
        this.tableStatus = tableStatus;
    }

    public Integer getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Integer achievementId) {
        this.achievementId = achievementId;
    }

    public String getIntellectualNo() {
        return intellectualNo;
    }

    public void setIntellectualNo(String intellectualNo) {
        this.intellectualNo = intellectualNo;
    }

    public String getIntellectualName() {
        return intellectualName;
    }

    public void setIntellectualName(String intellectualName) {
        this.intellectualName = intellectualName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(Integer auditFlag) {
        this.auditFlag = auditFlag;
    }
}

