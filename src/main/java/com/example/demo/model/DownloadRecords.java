package com.example.demo.model;

import java.io.Serializable;

/**
 * (DownloadRecords)实体类
 *
 * @author makejava
 * @since 2024-12-12 15:59:11
 */
public class DownloadRecords implements Serializable {
    private static final long serialVersionUID = 747505763306396122L;

    private Integer downloadId;

    private Integer achievementId;

    private Integer templateId;

    private Integer userId;

    private String downloadTime;

    private Boolean tableStatus;


    public Integer getDownloadId() {
        return downloadId;
    }

    public void setDownloadId(Integer downloadId) {
        this.downloadId = downloadId;
    }

    public Integer getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Integer achievementId) {
        this.achievementId = achievementId;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDownloadTime() {
        return downloadTime;
    }

    public void setDownloadTime(String downloadTime) {
        this.downloadTime = downloadTime;
    }

    public Boolean getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(Boolean tableStatus) {
        this.tableStatus = tableStatus;
    }

}

