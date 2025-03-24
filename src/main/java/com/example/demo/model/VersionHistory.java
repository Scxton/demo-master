package com.example.demo.model;

import java.io.Serializable;

/**
 * (VersionHistory)实体类
 *
 * @author makejava
 * @since 2024-12-12 16:00:23
 */
public class VersionHistory implements Serializable {
    private static final long serialVersionUID = 279316792416724918L;

    private Integer versionId;

    private Integer achievementId;

    private String versionNumber;

    private String updateContent;

    private String updateTime;

    private Integer userId;

    private Boolean tableStatus;


    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    public Integer getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Integer achievementId) {
        this.achievementId = achievementId;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getUpdateContent() {
        return updateContent;
    }

    public void setUpdateContent(String updateContent) {
        this.updateContent = updateContent;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(Boolean tableStatus) {
        this.tableStatus = tableStatus;
    }

}

