package com.example.demo.model;
import java.io.Serializable;

/**
 * (AchievementCheckTemplate)实体类
 *
 * @author makejava
 * @since 2024-12-10 14:52:10
 */
public class AchievementCheckTemplate implements Serializable {
    private static final long serialVersionUID = -97864990447162475L;

    private Integer templateId;

    private String templateType;

    private String templateName;

    private String templateIntro;

    private String remarks;

    private String uploadTime;

    private Integer userId;

    private String versionNumber;

    private String templateStoragepath;

    private Boolean tableStatus;

    private Boolean reviewStatus;

    private String  updateTime;


    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateIntro() {
        return templateIntro;
    }

    public void setTemplateIntro(String templateIntro) {
        this.templateIntro = templateIntro;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getTemplateStoragepath() {
        return templateStoragepath;
    }

    public void setTemplateStoragepath(String templateStoragepath) {
        this.templateStoragepath = templateStoragepath;
    }

    public Boolean getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(Boolean tableStatus) {
        this.tableStatus = tableStatus;
    }

    public Boolean getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(Boolean reviewStatus) {
        this.reviewStatus = reviewStatus;
    }
    public String getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

}

