package com.example.demo.model;


import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
@Slf4j
/**
 * (AchievementTable)实体类
 *
 * @author makejava
 * @since 2025-01-15 11:03:53
 */
public class AchievementTable implements Serializable {
    private static final long serialVersionUID = -41145833230926355L;

    private Integer achievementId;

    private String achievementName;

    private String achievementCategory;

    private String achievementForm;

    private Integer intellectualPropertyId;

    private Integer achievementBelongingOrganization;

    private Integer projectId;

    private String achievementVersion;

    private String achievementIntro;

    private Integer userId;

    private String uploadTime;

    private Integer templateId;

    private String remarks;

    private Integer achievementDownloadCount;

    private Integer searchCount;

    private Boolean tableStatus;

    private String organizationName;

    private String achievementNo;

    private String projectNo;

    private String userName;

    private Integer auditFlag;

    private String subjectCategory;

    private String technologyCategory;

    public String getSubjectCategory() {
        return subjectCategory;
    }

    public void setSubjectCategory(String subjectCategory) {
        this.subjectCategory = subjectCategory;
    }

    public String getTechnologyCategory() {
        return technologyCategory;
    }

    public void setTechnologyCategory(String technologyCategory) {
        this.technologyCategory = technologyCategory;
    }
    public Integer getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Integer achievementId) {
        this.achievementId = achievementId;
    }

    public String getAchievementName() {
        return achievementName;
    }

    public void setAchievementName(String achievementName) {
        this.achievementName = achievementName;
    }

    public String getAchievementCategory() {
        return achievementCategory;
    }

    public void setAchievementCategory(String achievementCategory) {
        this.achievementCategory = achievementCategory;
    }

    public String getAchievementForm() {
        return achievementForm;
    }

    public void setAchievementForm(String achievementForm) {
        this.achievementForm = achievementForm;
    }

    public Integer getIntellectualPropertyId() {
        return intellectualPropertyId;
    }

    public void setIntellectualPropertyId(Integer intellectualPropertyId) {
        this.intellectualPropertyId = intellectualPropertyId;
    }

    public Integer getAchievementBelongingOrganization() {
        return achievementBelongingOrganization;
    }

    public void setAchievementBelongingOrganization(Integer achievementBelongingOrganization) {
        this.achievementBelongingOrganization = achievementBelongingOrganization;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getAchievementVersion() {
        return achievementVersion;
    }

    public void setAchievementVersion(String achievementVersion) {
        this.achievementVersion = achievementVersion;
    }

    public String getAchievementIntro() {
        return achievementIntro;
    }

    public void setAchievementIntro(String achievementIntro) {
        this.achievementIntro = achievementIntro;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getAchievementDownloadCount() {

        return achievementDownloadCount;

    }

    public void setAchievementDownloadCount(Integer achievementDownloadCount) {

        this.achievementDownloadCount = achievementDownloadCount;
    }

    public Integer getSearchCount() {
        return searchCount;
    }

    public void setSearchCount(Integer searchCount) {
        this.searchCount = searchCount;
    }

    public Boolean getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(Boolean tableStatus) {
        this.tableStatus = tableStatus;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getAchievementNo() {
        return achievementNo;
    }

    public void setAchievementNo(String achievementNo) {
        this.achievementNo = achievementNo;
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

